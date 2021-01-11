package kata.ramon.pokeapicooker.domain.exception;

public class MandatoryPokemonWeightException extends RuntimeException {
    public MandatoryPokemonWeightException() {
        super("Pokemon weight is mandatory");
    }
}
