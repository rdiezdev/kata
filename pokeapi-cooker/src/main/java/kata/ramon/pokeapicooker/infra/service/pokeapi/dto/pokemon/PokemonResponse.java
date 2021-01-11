package kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "base_experience",
        "height",
        "game_indices",
        "name",
        "weight"
})
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("game_indices")
    private List<GameIndex> gameIndices = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private Integer weight;

}

