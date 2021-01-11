package kata.ramon.pokeapicooker.infra.repository.mysql.mapper;

import kata.ramon.pokeapicooker.domain.Pokemon;
import kata.ramon.pokeapicooker.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapicooker.domain.vo.PokemonHeight;
import kata.ramon.pokeapicooker.domain.vo.PokemonName;
import kata.ramon.pokeapicooker.domain.vo.PokemonWeight;
import kata.ramon.pokeapicooker.infra.repository.mysql.dao.PokemonDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class PokemonsDAOMapper {

    @Mapping(source = "pokemon.height.value", target = "height")
    @Mapping(source = "pokemon.name.value", target = "name")
    @Mapping(source = "pokemon.weight.value", target = "weight")
    @Mapping(source = "pokemon.baseExperience.value", target = "baseExperience")
    public abstract PokemonDAO toDAO(Pokemon pokemon);

    protected abstract PokemonName toPokemonName(String name);
    protected abstract PokemonWeight toPokemonWeight(Integer weight);
    protected abstract PokemonHeight toPokemonHeight(Integer height);
    protected abstract PokemonBaseExperience toPokemonBaseExperience(Integer baseExperience);
}
