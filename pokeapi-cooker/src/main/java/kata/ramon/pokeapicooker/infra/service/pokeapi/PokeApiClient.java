package kata.ramon.pokeapicooker.infra.service.pokeapi;

import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon.PokemonResponse;
import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemonlist.PokemonListResponse;
import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemontotal.PokemonTotalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokeApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon")
    PokemonListResponse getPokemons(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{pokemonId}")
    PokemonResponse getPokemon(@PathVariable("pokemonId") Integer pokemonId);

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon?limit=1")
    PokemonTotalResponse getTotalPokemons();
}