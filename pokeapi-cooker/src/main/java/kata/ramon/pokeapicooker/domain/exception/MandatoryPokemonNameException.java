package kata.ramon.pokeapicooker.domain.exception;

public class MandatoryPokemonNameException extends RuntimeException {
    public MandatoryPokemonNameException() {
        super("Pokemon name is mandatory");
    }
}
