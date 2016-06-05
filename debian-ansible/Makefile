build:
	docker build --force-rm -t debian/jessie-ansible .

run: build
	docker-compose run -d --rm --service-ports debian/jessie-ansible
