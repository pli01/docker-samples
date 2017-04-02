# DOCKER-VERSION 1.1.2
# VERSION        0.1

FROM debian/jessie:latest

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get -qqy update && \
    apt-get install -y rsyslog vim && \
    apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

RUN sed -i -e 's/#$ModLoad imudp/$ModLoad imudp/' /etc/rsyslog.conf && \
    sed -i -e 's/#$UDPServerRun 514/$UDPServerRun 514/' /etc/rsyslog.conf && \
    sed -i -e 's/#$ModLoad imtcp/$ModLoad imtcp/' /etc/rsyslog.conf && \
    sed -i -e 's/#$InputTCPServerRun 514/$InputTCPServerRun 514/' /etc/rsyslog.conf

ADD logstash-json.conf /etc/rsyslog.d/01-logstash-json.conf
ADD jsonparse.conf /etc/rsyslog.d/02-jsonparse.conf
ADD output.conf /etc/rsyslog.d/99-output.conf
ADD start.sh /start.sh
RUN chmod +x /start.sh

EXPOSE 514/tcp 514/udp

CMD ["/start.sh"]
