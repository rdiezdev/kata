package kata.ramon.pokeapi.application;

import kata.ramon.pokeapi.domain.Pokemon;
import kata.ramon.pokeapi.domain.service.GetTopStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTopPokemonsByCriteriaUseCase {

    private final Integer DEFAULT_RANK = 5;
    private final List<GetTopStrategy> getTopStrategies;

    public List<Pokemon> execute(TopPokemonCriteria criteria, Optional<Integer> rankingSize) {
        return this.getTopStrategies.stream()
                .filter(getTopStrategy -> getTopStrategy.canHandle(criteria))
                .findFirst()
                .orElseThrow()
                .execute(rankingSize.orElse(DEFAULT_RANK));
    }
}
