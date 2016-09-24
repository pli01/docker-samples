FROM debian-base:latest
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get -qqy update && \
    apt-get -qqy upgrade && \
    apt-get -qqy clean && \
    apt-get autoremove && \
    rm -rf /var/lib/apt/lists/*
