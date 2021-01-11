package kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemontotal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonTotalResponse {

    @JsonProperty("count")
    private Integer count;

}