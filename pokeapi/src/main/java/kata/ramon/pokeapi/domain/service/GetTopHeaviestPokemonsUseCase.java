package kata.ramon.pokeapi.domain.service;

import kata.ramon.pokeapi.application.TopPokemonCriteria;
import kata.ramon.pokeapi.domain.Pokemon;
import kata.ramon.pokeapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopHeaviestPokemonsUseCase implements GetTopStrategy{

    private final Integer DEFAULT_RANK = 5;
    private final PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> execute(Integer rankingSize) {
        return pokemonRepository.topHeaviest(rankingSize);
    }

    @Override
    public boolean canHandle(TopPokemonCriteria criteria) {
        return criteria.equals(TopPokemonCriteria.WEIGHT);
    }
}
