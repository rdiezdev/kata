## POKEAPI KATA

### Main features:
- Implement hexagonal architecture
- Do some Integration & Unit test (On the pokeapi microservice)
- Implement strategy pattern
- Docker environment & easy to build & run
- Lombok & Mapstruct

This kata is composed of two microservices:

### pokeapi-cooker:
This one is in charge of scrapping all the pokemons from the external API.
 
Is a cron job that will be executed every hour.

### pokeapi-cooker:
This ms will expose all the endpoints

```
Highest pokemons
http://localhost:8080/top/pokemons/highest

Heaviest pokemons
http://localhost:8080/top/pokemons/heaviest

Highest pokemons
http://localhost:8080/top/pokemons/greatest-base-experience
```

You can specify the ranking size with `ranking-size` query parameter. (default = 5, max = 10) 
```
http://localhost:8080/top/pokemons/greatest-base-experience?ranking-size=10
```

### Installation
There is a Makefile ready to be used.

To build and run the application simply type

```
make run 
```

### Improvements

- Add @Cacheable and a distributed cache (redis or couchbase for instance)
- Swagger documentation
- Add more testing
- Improve error handling (very basic), mapping domain exceptions to rest codes and so on.
- Default language to english (currently is takeing the system locale)
- Refactor som bussines rules to the domain layer
- ...

