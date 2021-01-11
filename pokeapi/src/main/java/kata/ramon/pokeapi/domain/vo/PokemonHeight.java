package kata.ramon.pokeapi.domain.vo;

import kata.ramon.pokeapi.domain.exception.InvalidPokemonHeightException;
import kata.ramon.pokeapi.domain.exception.MandatoryPokemonHeightException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PokemonHeight {
    private final Float value;

    public PokemonHeight(Float value) {
        assureNotNull(value);
        assureValid(value);
        this.value = value;
    }

    private void assureNotNull(Float value) {
        if( value == null) {
            throw new MandatoryPokemonHeightException();
        }
    }

    private void assureValid(Float value) {

        if (value <= 0) {
            throw new InvalidPokemonHeightException(value);
        }
    }
}
