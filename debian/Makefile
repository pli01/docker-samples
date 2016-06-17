name ?= debian
tag  ?= latest
build_args += $(shell [ -z "${http_proxy}" ] || echo " --build-arg http_proxy=${http_proxy} ")
build_args += $(shell [ -z "${https_proxy}" ] || echo " --build-arg https_proxy=${http_proxy} ")

build:
	docker build $(build_args) --force-rm -t $(name):$(tag) .

run: build
	docker-compose run -d --rm --service-ports $(name):$(tag)
