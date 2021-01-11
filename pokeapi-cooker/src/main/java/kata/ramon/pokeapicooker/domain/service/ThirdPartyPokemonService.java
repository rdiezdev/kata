package kata.ramon.pokeapicooker.domain.service;

import kata.ramon.pokeapicooker.domain.Pokemon;

import java.util.Optional;
import java.util.Set;

public interface ThirdPartyPokemonService {

    Set<Pokemon> get(Integer offset, Optional<Integer> limit);
    Integer getTotal();
}
