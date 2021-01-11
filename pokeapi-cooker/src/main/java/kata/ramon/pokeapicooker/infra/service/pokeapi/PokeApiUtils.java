package kata.ramon.pokeapicooker.infra.service.pokeapi;

import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemonlist.PokemonListItem;

import java.net.URI;
import java.net.URISyntaxException;

public class PokeApiUtils {

    public static Integer getId(PokemonListItem item) {
        try {
            URI uri = new URI(item.getUrl());
            String path = uri.getPath();
            path = removeLeadingSlash(path);
            return getId(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Integer getId(String path) {
        return Integer.parseInt(path.substring(path.lastIndexOf('/') + 1));
    }

    private static String removeLeadingSlash(String path) {
        if (path.lastIndexOf("/") == path.length() - 1) {
            return path.replaceFirst("/$", "");
        }
        return path;
    }
}
