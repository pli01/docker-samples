apt-get -qq update && apt-get install -qqy curl git

cd /opt
curl -o $(basename https://oss.sonatype.org/content/repositories/releases/com/floragunn/search-guard-5/5.2.2-11/search-guard-5-5.2.2-11.zip) https://oss.sonatype.org/content/repositories/releases/com/floragunn/search-guard-5/5.2.2-11/search-guard-5-5.2.2-11.zip -L

cd /opt/elasticsearch
bin/elasticsearch-plugin install  file:///opt/search-guard-5-5.2.2-11.zip

cd /opt
git clone https://github.com/floragunncom/search-guard-ssl.git
cd search-guard-ssl/example-pki-scripts
./example.sh
cp truststore.jks node-0-keystore.jks /etc/elasticsearch

cat <<EOF >> /etc/elasticsearch/elasticsearch.yml
searchguard.ssl.transport.keystore_filepath: node-0-keystore.jks
searchguard.ssl.transport.keystore_password: changeit
searchguard.ssl.transport.truststore_filepath: truststore.jks
searchguard.ssl.transport.truststore_password: changeit
searchguard.ssl.transport.enforce_hostname_verification: false
EOF

export ES_HEAP_SIZE=1g
sed -i.back -e 's/^-Xms.*/-Xms1g/g ; s/^-Xmx.*/-Xmx1g/g' /etc/elasticsearch/elasticsearch.yml 
service elasticsearch start

cd /opt/elasticsearch
chmod +x plugins/search-guard-5/tools/*.sh
plugins/search-guard-5/tools/sgadmin.sh -h localhost -cd plugins/search-guard-5/sgconfig/ -ks /etc/elasticsearch/node-0-keystore.jks -ts /etc/elasticsearch/truststore.jks -nhnv

CONNECT_IP=localhost
curl -Ss -XGET    --insecure  -u spock:spock http://$CONNECT_IP:9200/_searchguard/authinfo?pretty 

service elasticsearch stop
