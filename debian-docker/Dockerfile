FROM debian:jessie
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get -y clean ; apt-get -qy update && \
    apt-get install -qy \
     apt-transport-https \
     ca-certificates \
     curl \
     sudo \
     gnupg2 \
     make \
     python-pip \
     python-apt \
     rsync \
     file \
     vim \
     dos2unix \
     software-properties-common && \
    apt-get -qqy clean && \
    apt-get autoremove && \
    rm -rf /var/lib/apt/lists/*

#     python-dev \
#     libyaml-dev \
#     libffi-dev 

RUN curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg | sudo apt-key add -

RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
   $(lsb_release -cs) \
   stable"

RUN apt-get -qqy update && \
    apt-get install -qy docker-ce

RUN pip install docker-compose

RUN echo "debian ALL=NOPASSWD: ALL" >> /etc/sudoers ; \
    useradd -m debian && \
    adduser debian docker && \
    adduser debian staff

USER debian
