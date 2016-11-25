FROM openjdk:8-jdk
ADD ansible /srv/example/
WORKDIR /srv/example

RUN echo ${http_proxy}

## Run Ansible to configure the Docker image
RUN ansible-playbook site.yml -c local -v -e jenkins_security_realm=jenkins

RUN apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*
CMD /etc/init.d/jenkins start; tail -f /var/log/jenkins/jenkins.log
