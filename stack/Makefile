DOCKER_COMPOSE_FILE ?= docker-compose.yml
SCALE ?= ctx=1

all:
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) up
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) scale SCALE="ctx=1"
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) rm
config:
	docker-compose -f $(DOCKER_COMPOSE_FILE) config
up: config
	export SSH_KEY="$$(cat ~/.ssh/id_rsa.pub)" ; \
	docker-compose -f $(DOCKER_COMPOSE_FILE) up -d
stop:
	docker-compose -f $(DOCKER_COMPOSE_FILE) stop
down:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down
rm: stop down
	docker-compose -f $(DOCKER_COMPOSE_FILE) rm -f -v
logs:
	docker-compose -f $(DOCKER_COMPOSE_FILE) logs
scale:
	export SSH_KEY="$$(cat ~/.ssh/id_rsa.pub)" ; \
	docker-compose -f $(DOCKER_COMPOSE_FILE) scale $(SCALE)
show:
	@docker inspect -f '{{.Name | printf "[%s]\n" }}{{ .Name }} ansible_ssh_host={{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}} ansible_ssh_user=docker'  $$(docker ps -q -f name=stack_)|sed -e 's|/||g'
test-ssh: inventory
	export ANSIBLE_HOST_KEY_CHECKING=False ; ansible -i inventory 'all' -m shell -a "uname -a"
