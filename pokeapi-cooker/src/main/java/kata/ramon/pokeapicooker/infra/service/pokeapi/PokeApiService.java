package kata.ramon.pokeapicooker.infra.service.pokeapi;

import kata.ramon.pokeapicooker.domain.Pokemon;
import kata.ramon.pokeapicooker.domain.service.ThirdPartyPokemonService;
import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon.PokemonResponse;
import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemonlist.PokemonListItem;
import kata.ramon.pokeapicooker.infra.service.pokeapi.mapper.PokemonsResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PokeApiService implements ThirdPartyPokemonService {

    private final Integer DEFAULT_LIMIT = 20;
    private final PokeApiClient pokeApiClient;
    private final PokemonsResponseMapper pokemonsResponseMapper;
    @Value("${pokeapi.delay-between-calls}")
    private Integer delayBetweenCalls;

    @SneakyThrows
    @Override
    public Set<Pokemon> get(Integer offset, Optional<Integer> limit) {
        Set<Pokemon> pokemons = new HashSet<>();
        List<PokemonListItem> response = this.pokeApiClient.getPokemons(offset, limit.orElse(DEFAULT_LIMIT)).getResults();

        for (PokemonListItem item : response) {

            Integer pokemonId = PokeApiUtils.getId(item);

            // Delay between calls to avoid being banned
            TimeUnit.MILLISECONDS.sleep(delayBetweenCalls);

            PokemonResponse pokemon = this.pokeApiClient.getPokemon(pokemonId);

            if(isOnRedVersion(pokemon)) {
                pokemons.add(this.pokemonsResponseMapper.toDomain(pokemon));
            }
        }

        return pokemons;
    }

    private boolean isOnRedVersion(PokemonResponse pokemon) {
        return pokemon.getGameIndices().stream().map(gameIndex -> gameIndex.version.name)
                .anyMatch(versionName -> versionName.equalsIgnoreCase("RED"));
    }

    @Override
    public Integer getTotal() {
        return this.pokeApiClient.getTotalPokemons().getCount();
    }


}
