package kata.ramon.pokeapicooker.infra.repository.mysql;

import kata.ramon.pokeapicooker.domain.Pokemon;
import kata.ramon.pokeapicooker.domain.repository.PokemonRepository;
import kata.ramon.pokeapicooker.infra.repository.mysql.dao.PokemonDAO;
import kata.ramon.pokeapicooker.infra.repository.mysql.mapper.PokemonsDAOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MysqlPokemonRepository implements PokemonRepository {

    private final JpaPokemonRepository jpaPokemonRepository;
    private final PokemonsDAOMapper pokemonsDAOMapper;

    @Override
    public void save(Set<Pokemon> pokemons) {

        Set<PokemonDAO> pokemonsToSave = pokemons.stream()
                .map(pokemon -> {
                    Optional<PokemonDAO> foundPokemon = jpaPokemonRepository.findByName(pokemon.getName().getValue());

                    if (foundPokemon.isPresent()) {
                        return mergeData(foundPokemon.get(), pokemon);
                    }

                    return this.pokemonsDAOMapper.toDAO(pokemon);
                })
                .collect(Collectors.toSet());

        jpaPokemonRepository.saveAll(pokemonsToSave);
    }

    private PokemonDAO mergeData(PokemonDAO foundPokemon, Pokemon pokemon) {
        foundPokemon.setWeight(pokemon.getWeight().getValue());
        foundPokemon.setBaseExperience(pokemon.getBaseExperience().getValue());
        foundPokemon.setHeight(pokemon.getHeight().getValue());

        return foundPokemon;
    }

}