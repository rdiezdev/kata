package kata.ramon.pokeapicooker.domain.exception;

public class InvalidPokemonBaseExperienceException extends RuntimeException {

    public InvalidPokemonBaseExperienceException(Integer value) {
        super(String.format("Pokemon base experience should be a positive number. Current value: %d", value));
    }
}
