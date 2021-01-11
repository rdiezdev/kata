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
@RequestMapping("/top/pokemons")
@Validated
@RequiredArgsConstructor
public class TopHeaviestPokemonController {

    private final GetTopPokemonsByCriteriaUseCase getTopPokemonsByCriteriaUseCase;

    @GetMapping("heaviest")
    public List<HeavyPokemon> getHeaviestPokemons(@RequestParam(value = "ranking-size", required = false) @Max(10) Integer rankingSize) {

        return this.getTopPokemonsByCriteriaUseCase.execute(TopPokemonCriteria.WEIGHT, Optional.ofNullable(rankingSize))
                .stream()
                .map(pokemon -> new HeavyPokemon(pokemon.getId().getValue(), pokemon.getName().getValue(), pokemon.getWeight().getValue()))
                .collect(Collectors.toList());
    }


}

@Getter
@AllArgsConstructor
class HeavyPokemon {
    private Integer id;
    private String name;
    private Float weight;
}
