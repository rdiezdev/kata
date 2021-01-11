package kata.ramon.pokeapicooker.domain.exception;

public class BlankPokemonNameException extends RuntimeException {
    public BlankPokemonNameException() {
        super("Pokemon name should have at least 1 character");
    }
}
