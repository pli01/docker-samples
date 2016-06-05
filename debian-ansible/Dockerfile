FROM debian:latest
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get -qqy update && \
    apt-get -qqy upgrade && \
    apt-get install -y ansible && \
    apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

RUN echo '[local]\nlocalhost\n' > /etc/ansible/hosts
