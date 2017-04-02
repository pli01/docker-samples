DOCKER_COMPOSE_FILE ?= docker-compose.yml
PROJECT ?= stack
SCALE ?= ctx=1

COMPOSE_ARGS = -f $(DOCKER_COMPOSE_FILE) -p $(PROJECT)

all:
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) up
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) scale SCALE="ctx=1"
	@echo make DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE) rm
config:
	docker-compose $(COMPOSE_ARGS) config
up: config
	export SSH_KEY="$$(cat ~/.ssh/id_rsa.pub)" ; \
	docker-compose $(COMPOSE_ARGS) up -d
stop:
	docker-compose $(COMPOSE_ARGS) stop
down:
	docker-compose $(COMPOSE_ARGS) down
rm: stop down
	docker-compose $(COMPOSE_ARGS) rm -f -v
logs:
	docker-compose $(COMPOSE_ARGS) logs
scale:
	export SSH_KEY="$$(cat ~/.ssh/id_rsa.pub)" ; \
        docker-compose $(COMPOSE_ARGS) scale $(SCALE)
show:
	@docker inspect -f '{{.Name | printf "[%s]\n" }}{{ .Name }} ansible_ssh_host={{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}} ansible_ssh_user=docker'  $$(docker ps -q -f name=$(PROJECT))|sed -e 's|/||g'

test-ssh: inventory.d
	export ANSIBLE_HOST_KEY_CHECKING=False ; ansible -i inventory.d 'all' -m shell -a "uname -a"

stack-up: log-up elk-up web-up
stack-rm: log-rm elk-rm web-rm

elk-up:
	make DOCKER_COMPOSE_FILE=docker-compose-elk.yml PROJECT=elk up

log-up:
	make DOCKER_COMPOSE_FILE=docker-compose-log.yml PROJECT=log up

web-up:
	make DOCKER_COMPOSE_FILE=docker-compose-web.yml PROJECT=web up

elk-rm:
	make DOCKER_COMPOSE_FILE=docker-compose-elk.yml PROJECT=elk rm

log-rm:
	make DOCKER_COMPOSE_FILE=docker-compose-log.yml PROJECT=log rm

web-rm:
	make DOCKER_COMPOSE_FILE=docker-compose-web.yml PROJECT=web rm
