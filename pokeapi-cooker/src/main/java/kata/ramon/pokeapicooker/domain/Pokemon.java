package kata.ramon.pokeapicooker.domain;

import kata.ramon.pokeapicooker.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapicooker.domain.vo.PokemonHeight;
import kata.ramon.pokeapicooker.domain.vo.PokemonName;
import kata.ramon.pokeapicooker.domain.vo.PokemonWeight;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Pokemon {
    private final PokemonName name;
    private final PokemonWeight weight;
    private final PokemonHeight height;
    private final PokemonBaseExperience baseExperience;
}
