package kata.ramon.pokeapicooker.domain.exception;

public class InvalidPokemonWeightException extends RuntimeException {
    public InvalidPokemonWeightException(Float value) {
        super(String.format("Pokemon weight should be a positive number. Current value: %f", value));
    }
}
