name ?= nginx
tag  ?= latest
http_proxy ?= 
#http_proxy ?= http://192.168.20.100:8888

build:
	docker build --build-arg http_proxy=$(http_proxy) --force-rm -t $(name):$(tag) .

run: build
	docker-compose run -d --rm --service-ports $(name):$(tag)
