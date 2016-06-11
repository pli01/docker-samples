name ?= rsyslog
tag  ?= latest

build:
	docker build --force-rm -t $(name):$(tag) .

run: build
	docker-compose run -d --rm --service-ports $(name):$(tag)
