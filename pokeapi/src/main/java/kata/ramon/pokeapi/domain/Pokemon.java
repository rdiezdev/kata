package kata.ramon.pokeapi.domain;

import kata.ramon.pokeapi.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapi.domain.vo.PokemonHeight;
import kata.ramon.pokeapi.domain.vo.PokemonId;
import kata.ramon.pokeapi.domain.vo.PokemonName;
import kata.ramon.pokeapi.domain.vo.PokemonWeight;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Pokemon {
    private final PokemonId id;
    private final PokemonName name;
    private final PokemonWeight weight;
    private final PokemonHeight height;
    private final PokemonBaseExperience baseExperience;
}
