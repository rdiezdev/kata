package kata.ramon.pokeapicooker.domain.repository;

import kata.ramon.pokeapicooker.domain.Pokemon;

import java.util.Set;

public interface PokemonRepository {

    void save(Set<Pokemon> pokemons);
}
