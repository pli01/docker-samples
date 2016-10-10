FROM debian/jessie:latest

# sample args
ARG myvar

WORKDIR /local

RUN echo ${http_proxy}

# Install requirements for unarchive
RUN apt-get -qqy update && \
    apt-get install -y unzip tar

# Get playbook (ansible-pull like from http)
RUN ansible -i 'localhost,' -c local localhost -m unarchive -a 'dest=/local/ copy=no src=https://github.com/pli01/ansible-samples/archive/master.zip' -vv
# Run Ansible to configure the Docker image

RUN cd ansible-samples-master && \
    ansible-playbook -i hosts -c local site.yml -e myvar=${myvar}

RUN apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

# Other Dockerfile directives are still valid
CMD ["/bin/bash"]

