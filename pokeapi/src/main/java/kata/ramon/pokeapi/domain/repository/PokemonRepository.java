package kata.ramon.pokeapi.domain.repository;

import kata.ramon.pokeapi.domain.Pokemon;

import java.util.List;

public interface PokemonRepository {

    List<Pokemon> topHeaviest(Integer rankSize);
    List<Pokemon> topHighest(Integer rankSize);
    List<Pokemon> topGreatestBaseExperience(Integer rankSize);

}
