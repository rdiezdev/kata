package kata.ramon.pokeapi.domain.vo;

import kata.ramon.pokeapi.domain.exception.InvalidPokemonIdException;
import kata.ramon.pokeapi.domain.exception.MandatoryPokemonHeightException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PokemonId {
    private final Integer value;

    public PokemonId(Integer value) {
        assureNotNull(value);
        assureValid(value);
        this.value = value;
    }

    private void assureNotNull(Integer value) {
        if( value == null) {
            throw new MandatoryPokemonHeightException();
        }
    }

    private void assureValid(Integer value) {

        if (value < 0) {
            throw new InvalidPokemonIdException(value);
        }
    }
}
