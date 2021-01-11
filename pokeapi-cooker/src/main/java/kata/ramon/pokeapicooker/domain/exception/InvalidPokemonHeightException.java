package kata.ramon.pokeapicooker.domain.exception;

public class InvalidPokemonHeightException extends RuntimeException {
    public InvalidPokemonHeightException(Float value) {
        super(String.format("Pokemon base experience should be a positive number. Current value: %f", value));
    }
}
