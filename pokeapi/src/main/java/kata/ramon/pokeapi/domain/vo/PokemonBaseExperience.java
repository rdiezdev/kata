package kata.ramon.pokeapi.domain.vo;

import kata.ramon.pokeapi.domain.exception.InvalidPokemonBaseExperienceException;
import kata.ramon.pokeapi.domain.exception.MandatoryPokemonBaseExperienceException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PokemonBaseExperience {
    private final Integer value;

    public PokemonBaseExperience(Integer value) {
        assureNotNull(value);
        assureValid(value);
        this.value = value;
    }

    private void assureNotNull(Integer value) {
        if( value == null) {
            throw new MandatoryPokemonBaseExperienceException();
        }
    }

    private void assureValid(Integer value) {

        if (value <= 0) {
            throw new InvalidPokemonBaseExperienceException(value);
        }
    }
}
