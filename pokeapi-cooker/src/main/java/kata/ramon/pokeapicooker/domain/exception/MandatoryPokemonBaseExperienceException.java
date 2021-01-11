package kata.ramon.pokeapicooker.domain.exception;

public class MandatoryPokemonBaseExperienceException extends RuntimeException {
    public MandatoryPokemonBaseExperienceException() {
        super("Pokemon base experience is mandatory");
    }
}
