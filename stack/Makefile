all:
	echo make up down
up:
	docker-compose -f docker-compose.yml up -d
stop:
	docker-compose -f docker-compose.yml stop
down:
	docker-compose -f docker-compose.yml down
rm: stop
	docker-compose -f docker-compose.yml rm --all -f
