package kata.ramon.pokeapi.infra.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql({"pokemons.sql"})
class TopHeaviestPokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHeaviestPokemons_whenRankingIsValid_shouldReturnPokemonsSortByWeightDesc() throws Exception {
        Integer rankingSize = 2;

        String expectedResponse = "[" +
                "{\"id\":1,\"name\":\"poke1\",\"weight\":100.0}," +
                "{\"id\":2,\"name\":\"poke2\",\"weight\":100.0}" +
                "]";

        mockMvc.perform(get("/pokemons/heaviest?ranking-size={rankingSize}", rankingSize))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedResponse));

    }

    @Test
    void getHeaviestPokemons_whenRankingIsInvalid_shouldReturnBadRequest() throws Exception {
        Integer rankingSize = 11;

        mockMvc.perform(get("/pokemons/heaviest?ranking-size={rankingSize}", rankingSize))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}