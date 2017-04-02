FROM debian-jessie-base:latest
ARG DEBIAN_FRONTEND=noninteractive
RUN echo "deb http://httpredir.debian.org/debian jessie-backports main" >> /etc/apt/sources.list.d/jessie-backports.list
RUN apt-get -qqy update && \
    apt-get -qqy upgrade && \
    apt-get -qqy clean && \
    apt-get autoremove && \
    rm -rf /var/lib/apt/lists/*
