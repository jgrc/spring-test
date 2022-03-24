DC = docker-compose -f docker-compose.yml

.PHONY: up stop restart down ps exec

up:
	$(DC) up -d
stop:
	$(DC) stop
restart:
	$(DC) restart java
down:
	$(DC) down
ps:
	$(DC) ps
exec:
	$(DC) exec java sh
