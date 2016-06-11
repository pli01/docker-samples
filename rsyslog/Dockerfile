# DOCKER-VERSION 1.1.2
# VERSION        0.1

FROM debian/jessie:latest

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get -qqy update && \
    apt-get install -y rsyslog && \
    apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

RUN sed -i -e 's/#$ModLoad imudp/$ModLoad imudp/' /etc/rsyslog.conf && \
    sed -i -e 's/#$UDPServerRun 514/$UDPServerRun 514/' /etc/rsyslog.conf && \
    sed -i -e 's/#$ModLoad imtcp/$ModLoad imtcp/' /etc/rsyslog.conf && \
    sed -i -e 's/#$InputTCPServerRun 514/$InputTCPServerRun 514/' /etc/rsyslog.conf && \
    echo "*.*     @elk:10514;ls_json" >> /etc/rsyslog.conf

ADD logstash-json.conf /etc/rsyslog.d/

EXPOSE 514/tcp 514/udp

ENTRYPOINT ["/usr/sbin/rsyslogd"]
CMD ["-n"]