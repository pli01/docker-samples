# DOCKER-VERSION 1.1.2
# VERSION        0.1

FROM debian/jessie:latest

ARG DEBIAN_FRONTEND=noninteractive

RUN echo "deb http://httpredir.debian.org/debian jessie-backports main" > /etc/apt/sources.list.d/jessie-backports.list
RUN apt-get -qqy update && \
    apt-get install -y vim curl git  && \
    apt-get install -y -t jessie-backports ansible openjdk-8-jre-headless ca-certificates-java  && \            
    apt-get -qqy remove systemd && \
    apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /opt && \
    cd /opt && git clone https://github.com/pli01/ansible-elasticsearch  && \
    mkdir -p /opt/playbooks/roles && \
    cd /opt/playbooks && ln -sf /opt/ansible-elasticsearch roles/elasticsearch && \
    cp /opt/ansible-elasticsearch/site.yml .

RUN ( cd /opt/playbooks && ansible-playbook -i localhost, -c local site.yml -v )

USER root
COPY es-docker /bin/es-docker
RUN chmod 0750 /bin/es-docker

ENTRYPOINT ["/bin/bash", "/bin/es-docker"]
CMD ["elasticsearch"]
EXPOSE 9200/tcp 9300/tcp
