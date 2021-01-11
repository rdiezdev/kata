package kata.ramon.pokeapicooker.infra.cron;

import kata.ramon.pokeapicooker.application.PullPokemonsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokemonPullerCron {

    private final PullPokemonsUseCase pullPokemonsUseCase;

    @Scheduled(fixedDelay = 3600000)
    public void PullAndStorePokemons() {
        this.pullPokemonsUseCase.execute();
    }
}
