package kata.ramon.pokeapicooker.infra.service.pokeapi.mapper;

import kata.ramon.pokeapicooker.domain.Pokemon;
import kata.ramon.pokeapicooker.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapicooker.domain.vo.PokemonHeight;
import kata.ramon.pokeapicooker.domain.vo.PokemonName;
import kata.ramon.pokeapicooker.domain.vo.PokemonWeight;
import kata.ramon.pokeapicooker.infra.service.pokeapi.dto.pokemon.PokemonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PokemonsResponseMapper {

    private static final String RED_VERSION_NAME = "RED";

    public abstract Pokemon toDomain(PokemonResponse pokemonResponse);

    @Mapping(target = "value")
    public abstract PokemonName toPokemonName(String value);

    @Mapping(target = "value")
    public abstract PokemonWeight toPokemonWeight(Integer value);

    @Mapping(target = "value")
    public abstract PokemonBaseExperience toPokemonBaseExperience(Integer value);

    @Mapping(target = "value")
    public abstract PokemonHeight toPokemonHeight(Integer value);

}
