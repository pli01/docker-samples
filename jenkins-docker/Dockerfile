FROM jenkinsci/jenkins:lts
ARG DEBIAN_FRONTEND=noninteractive
USER root
RUN apt-get -qqy clean && \
    apt-get -qqy update && \
    apt-get install -qy \
     apt-transport-https \
     ca-certificates \
     curl \
     sudo \
     gnupg2 \
     software-properties-common && \
    apt-get -qqy clean && \
    apt-get autoremove && \
    rm -rf /var/lib/apt/lists/*

RUN curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg | sudo apt-key add -

RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
   $(lsb_release -cs) \
   stable"

RUN apt-get -qqy update && \
    apt-get install -qy docker-ce

RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers ; \
    adduser jenkins docker && \
    adduser jenkins staff

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

RUN apt-get -qqy update && \
    apt-get install -qy python-pip && \
    pip install jenkins-job-builder

USER jenkins
