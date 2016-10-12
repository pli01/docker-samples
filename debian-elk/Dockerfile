FROM debian/jessie:latest

# sample args
ARG dest
ENV dest ${dest}
ARG url
ENV url ${url}

WORKDIR /local

RUN echo ${http_proxy}

# Install requirements for unarchive
RUN apt-get -qqy update && \
    apt-get install -y unzip tar git

# Get playbook (ansible-pull like from http)
#RUN ansible -i 'localhost,' -c local localhost -m unarchive -a 'dest=/local/${dest} copy=no src=${url}' -vv
RUN ansible -i 'localhost,' -c local localhost -m git -a 'repo=${url} dest=/local/${dest} clone=yes update=no' -vv

# Run Ansible to configure the Docker image
RUN cd ${dest} && \
    printf '[defaults]\nroles_path = ../' > ansible.cfg && \
    ansible-playbook -i tests/inventory -c local tests/test.yml

RUN apt-get -qqy clean && \
    rm -rf /var/lib/apt/lists/*

# Other Dockerfile directives are still valid
CMD ["/bin/bash"]

