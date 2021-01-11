package kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "url"
})
public class Version {
    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;
}