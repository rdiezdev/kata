package kata.ramon.pokeapi.domain.exception;

public class MandatoryPokemonBaseExperienceException extends RuntimeException {
    public MandatoryPokemonBaseExperienceException() {
        super("Pokemon base experience is mandatory");
    }
}
