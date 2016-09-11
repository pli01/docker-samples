FROM debian:latest
ARG DEBIAN_FRONTEND=noninteractive
RUN echo 'deb http://httpredir.debian.org/debian jessie-backports main' > /etc/apt/sources.list.d/jessie-backports.list
RUN apt-get -qqy update && \
    apt-get -qqy upgrade && \
    apt-get install -y ansible \
       -t jessie-backports && \
    apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

RUN echo '[local]\nlocalhost\n' > /etc/ansible/hosts
