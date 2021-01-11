package kata.ramon.pokeapi.domain.exception;

public class MandatoryPokemonIdException extends RuntimeException {
    public MandatoryPokemonIdException() {
        super("Pokemon id is mandatory");
    }
}
