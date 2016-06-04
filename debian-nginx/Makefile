build:
	docker build --force-rm -t nginx:latest .

run: build
	docker-compose run -d --rm --service-ports nginx
