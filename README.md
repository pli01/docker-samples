# docker-samples

- stack directory contains a docker-compose to build a full functionnal rpx/jenkins/elk/rabbit/rsyslog/tinyproxy
  - container web:  nginx reverse proxy wich expose 80 port and redirect /jenkins to jenkins container and /kibana to container kibana port
  - container rsyslog (transform to json and send to logstash (syslog input) in elk
  - container jenkins (https://github.com/jenkinsci/docker)
  - container elk (https://github.com/pli01/elk-docker.git)
  - container rabbitmq (https://github.com/pli01/rabbitmq.git)
  - container tinyproxy (https://github.com/francisbesset/docker-tinyproxy.git)

This stack depends on the following

- base-image: build an initial debian image , and import the container image in the local registry
- debian-ansible: build a minimal debian container (based on base image) and add ansible 
- debian-nginx: build nginx with ansible playbook (depends on the previous container)
- elk-input: build an elk with syslog input depends on elk container
- rsyslog: listen to 514 port and transform in json format and send to elk

