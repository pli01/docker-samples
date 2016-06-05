# docker-samples

- stack directory contains a docker-compose to build links between elk + jenkins + with nginx reverse proxy in front of them
  - container web:  nginx reverse proxy wich expose 80 port and redirect /jenkins to jenkins container and /kibana to container kibana port
  - container jenkins
  - container elk

This stack depends on the following

- base-image: build an initial debian image , and import the container image in the local registry
- debian-ansible: build a minimal debian container (based on base image) and add ansible 
- debian-nginx: build nginx with ansible playbook (depends on the previous container)
- depends on elk container and jenkins container

