DOCKER_COMPOSE_FILE ?= docker-compose.yml

all:
	@echo make up down DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_FILE)
config:
	docker-compose -f $(DOCKER_COMPOSE_FILE) config
up: config
	docker-compose -f $(DOCKER_COMPOSE_FILE) up -d
stop:
	docker-compose -f $(DOCKER_COMPOSE_FILE) stop
down:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down
logs:
	docker-compose -f $(DOCKER_COMPOSE_FILE) logs
rm: stop
	docker-compose -f $(DOCKER_COMPOSE_FILE) rm -f -v
