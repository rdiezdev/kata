package kata.ramon.pokeapi.domain.vo;

import kata.ramon.pokeapi.domain.exception.BlankPokemonNameException;
import kata.ramon.pokeapi.domain.exception.MandatoryPokemonNameException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PokemonName {
    private final String value;

    public PokemonName(String value) {
        assureIsValid(value);
        this.value = value;
    }

    private void assureIsValid(String value) {

        if(value == null) {
            throw new MandatoryPokemonNameException();
        }

        if(value.isBlank()) {
            throw new BlankPokemonNameException();
        }
    }
}
