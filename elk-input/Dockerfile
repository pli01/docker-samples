# Dockerfile for ELK stack
# Build with:
# docker build -t <repo-user>/elk .

# Run with:
# docker run -p 5601:5601 -p 9200:9200 -p 5044:5044 -p 5000:5000 -it --name elk <repo-user>/elk

FROM elk:latest
# filters
#ADD 03-rabbitmq-input.conf /etc/logstash/conf.d/03-rabbitmq-input.conf
ADD 04-syslog-input.conf /etc/logstash/conf.d/04-syslog-input.conf

EXPOSE 5601 9200 9300 5000 5044 10514/udp
VOLUME /var/lib/elasticsearch

CMD [ "/usr/local/bin/start.sh" ]
