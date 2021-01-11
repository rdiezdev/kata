package kata.ramon.pokeapicooker.application;

import kata.ramon.pokeapicooker.domain.Pokemon;
import kata.ramon.pokeapicooker.domain.repository.PokemonRepository;
import kata.ramon.pokeapicooker.domain.service.ThirdPartyPokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log4j2
public class PullPokemonsUseCase {

    private final ThirdPartyPokemonService thirdPartyPokemonService;
    private final PokemonRepository pokemonRepository;
    @Value("${pokeapi.batchSize:10}")
    private Integer batchSize;

    public void execute() {

        int offset = 0;
        Integer totalPokemons = this.thirdPartyPokemonService.getTotal();
        int totalBatches = (totalPokemons / batchSize) + (totalPokemons % batchSize == 0 ? 0 : 1);

        log.debug(String.format(":: Start processing %d pokemons in %d batches", totalPokemons, totalBatches));

        for(int currentBatch = 1; currentBatch <= totalBatches; currentBatch++) {

            log.debug(String.format(":: :: Processing batch #%d",currentBatch));

            Set<Pokemon> pokemons = this.thirdPartyPokemonService.get(offset, Optional.of(batchSize));

            this.pokemonRepository.save(pokemons);
            offset += batchSize;
        }

    }
}
