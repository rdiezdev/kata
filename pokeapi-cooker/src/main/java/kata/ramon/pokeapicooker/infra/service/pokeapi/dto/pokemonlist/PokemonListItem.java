package kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemonlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "url"
})
public class PokemonListItem {

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

}