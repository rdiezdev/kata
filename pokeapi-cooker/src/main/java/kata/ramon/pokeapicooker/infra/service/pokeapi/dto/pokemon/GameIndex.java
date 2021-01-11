package kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "game_index",
        "version"
})
public class GameIndex {

    @JsonProperty("game_index")
    public Integer gameIndex;
    @JsonProperty("version")
    public Version version;

}