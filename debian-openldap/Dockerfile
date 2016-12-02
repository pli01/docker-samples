FROM debian/jessie:latest

ADD ansible /srv/example/
WORKDIR /srv/example

RUN echo ${http_proxy}

## Run Ansible to configure the Docker image
RUN ansible-playbook site.yml -c local -v

RUN apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*
CMD /etc/init.d/slapd restart
