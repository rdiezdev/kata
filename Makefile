.DEFAULT_GOAL := build

build:
	@echo "📦 Building Pokeapi ..."
	@(cd ./pokeapi; ./mvnw clean package > /dev/null)
	@echo "📦 Building Pokeapi-Cooker ..."
	@(cd ./pokeapi-cooker; ./mvnw clean package > /dev/null)

test:
	@echo "🔦 Executing tests ..."
	@(cd ./pokeapi; ./mvnw clean test)

run: build
	@docker-compose up -d && echo "🚀 Wait a minute and the API will be ready!"
	@echo "Try with -> curl  http://localhost:8080/pokemons/heaviest"
