package kata.ramon.pokeapi.domain.service;

import kata.ramon.pokeapi.application.TopPokemonCriteria;
import kata.ramon.pokeapi.domain.Pokemon;
import kata.ramon.pokeapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopHighestPokemonsUseCase implements GetTopStrategy{

    private final PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> execute(Integer rankingSize) {
        return pokemonRepository.topHighest(rankingSize);
    }

    @Override
    public boolean canHandle(TopPokemonCriteria criteria) {
        return criteria.equals(TopPokemonCriteria.HEIGHT);
    }
}
