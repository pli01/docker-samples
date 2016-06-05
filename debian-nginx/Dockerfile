FROM debian/jessie:latest
ADD ansible /srv/example/
WORKDIR /srv/example

# Run Ansible to configure the Docker image
RUN ansible-playbook site.yml -c local -v --syntax-check && \
     ansible-playbook site.yml -c local -v

# Other Dockerfile directives are still valid
EXPOSE 80
CMD ["nginx"]
