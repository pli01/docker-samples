FROM debian:latest
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get -qqy update && \
    apt-get install -y ansible && \
    apt-get -qqy clean && \
    apt-get autoremove && \
    rm -rf /var/lib/apt/lists/*

RUN echo '[local]\nlocalhost\n' > /etc/ansible/hosts
