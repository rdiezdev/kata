package kata.ramon.pokeapi.domain.exception;

public class InvalidPokemonIdException extends RuntimeException {
    public InvalidPokemonIdException(Integer value) {
        super(String.format("Pokemon id should be a positive number. Current value: %d", value));
    }
}
