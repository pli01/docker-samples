DOCKER_COMPOSE_FILE ?= docker-compose.yml

all:
	@echo make up down DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE)
validate:
	docker-compose -f $(DOCKER_COMPOSE_FILE) config
up: validate
	docker-compose -f $(DOCKER_COMPOSE_FILE) up -d
stop:
	docker-compose -f $(DOCKER_COMPOSE_FILE) stop
down:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down
rm: stop
	docker-compose -f $(DOCKER_COMPOSE_FILE) rm  -f
