package kata.ramon.pokeapi.infra.rest;

import kata.ramon.pokeapi.application.GetTopPokemonsByCriteriaUseCase;
import kata.ramon.pokeapi.domain.service.GetTopStrategy;
import kata.ramon.pokeapi.application.TopPokemonCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/pokemons")
@Validated
@RequiredArgsConstructor
public class TopHighestPokemonController {

    private final GetTopPokemonsByCriteriaUseCase getTopPokemonsByCriteriaUseCase;

    @GetMapping("highest")
    public List<HighestPokemon> getHighestPokemons(@RequestParam(value = "ranking-size", required = false) @Max(10) Integer rankingSize) {

        return this.getTopPokemonsByCriteriaUseCase.execute(TopPokemonCriteria.HEIGHT, Optional.ofNullable(rankingSize))
                .stream()
                .map(pokemon -> new HighestPokemon(pokemon.getId().getValue(), pokemon.getName().getValue(), pokemon.getHeight().getValue()))
                .collect(Collectors.toList());
    }


}

@Getter
@RequiredArgsConstructor
class HighestPokemon {
    private final Integer id;
    private final String name;
    private final Float height;
}
