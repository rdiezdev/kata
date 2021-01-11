package kata.ramon.pokeapicooker.domain.vo;

import kata.ramon.pokeapicooker.domain.exception.InvalidPokemonWeightException;
import kata.ramon.pokeapicooker.domain.exception.MandatoryPokemonWeightException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PokemonWeight {
    private final Float value;

    public PokemonWeight(Float value) {
        assureNotNull(value);
        assureValid(value);
        this.value = value;
    }

    private void assureNotNull(Float value) {
        if( value == null) {
            throw new MandatoryPokemonWeightException();
        }
    }

    private void assureValid(Float value) {
        if (value < 0) {
            throw new InvalidPokemonWeightException(value);
        }
    }
}
