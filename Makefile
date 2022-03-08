DC = docker-compose -f docker-compose.yml
.PHONY: up stop down ps
up:
	$(DC) up -d
down:
	$(DC) down
