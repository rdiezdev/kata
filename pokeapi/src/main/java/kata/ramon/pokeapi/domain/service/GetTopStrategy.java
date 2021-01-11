package kata.ramon.pokeapi.domain.service;

import kata.ramon.pokeapi.application.TopPokemonCriteria;
import kata.ramon.pokeapi.domain.Pokemon;

import java.util.List;
import java.util.Optional;

public interface GetTopStrategy {
    boolean canHandle(TopPokemonCriteria criteria);

    List<Pokemon> execute(Integer rankingSize);
}
