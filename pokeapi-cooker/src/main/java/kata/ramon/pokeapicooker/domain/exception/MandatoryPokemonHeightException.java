package kata.ramon.pokeapicooker.domain.exception;

public class MandatoryPokemonHeightException extends RuntimeException {
    public MandatoryPokemonHeightException() {
        super("Pokemon height is mandatory");
    }
}
