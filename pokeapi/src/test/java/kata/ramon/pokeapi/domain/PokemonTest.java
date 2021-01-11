package kata.ramon.pokeapi.domain;

import kata.ramon.pokeapi.domain.exception.BlankPokemonNameException;
import kata.ramon.pokeapi.domain.exception.InvalidPokemonBaseExperienceException;
import kata.ramon.pokeapi.domain.exception.InvalidPokemonHeightException;
import kata.ramon.pokeapi.domain.exception.InvalidPokemonWeightException;
import kata.ramon.pokeapi.domain.exception.MandatoryPokemonNameException;
import kata.ramon.pokeapi.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapi.domain.vo.PokemonHeight;
import kata.ramon.pokeapi.domain.vo.PokemonId;
import kata.ramon.pokeapi.domain.vo.PokemonName;
import kata.ramon.pokeapi.domain.vo.PokemonWeight;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PokemonTest {

    @Test
    void makePokemon_whenValidValues_shouldReturnPokemon() {
        // given
        Integer id = 1;
        String name = "Some name";
        Float weight = 1F;
        Float height = 2F;
        Integer baseExperience = 10;

        // when
        Pokemon resultingPokemon = buildPokemon(id, name, weight, height, baseExperience);

        // then
        assertAll(() -> {
            assertThat(resultingPokemon.getId().getValue()).isEqualTo(id);
            assertThat(resultingPokemon.getName().getValue()).isEqualTo(name);
            assertThat(resultingPokemon.getBaseExperience().getValue()).isEqualTo(baseExperience);
            assertThat(resultingPokemon.getHeight().getValue()).isEqualTo(height);
            assertThat(resultingPokemon.getWeight().getValue()).isEqualTo(weight);
        });
    }

    @Test
    void makePokemon_whenNameIsBlank_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "";
        Float weight = 1F;
        Float height = 2F;
        Integer baseExperience = 10;

        // when
        assertThrows(BlankPokemonNameException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenNameIsNull_shouldThrowException() {
        // given
        Integer id = 1;
        String name = null;
        Float weight = 1F;
        Float height = 2F;
        Integer baseExperience = 10;

        // when
        assertThrows(MandatoryPokemonNameException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenWeightIsZero_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = 0F;
        Float height = 2F;
        Integer baseExperience = 10;

        // when
        assertThrows(InvalidPokemonWeightException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenWeightIsNegative_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = -1F;
        Float height = 2F;
        Integer baseExperience = 10;

        // when
        assertThrows(InvalidPokemonWeightException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenHeightIsZero_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = 1F;
        Float height = 0F;
        Integer baseExperience = 10;

        // when
        assertThrows(InvalidPokemonHeightException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenHeightIsNegative_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = 1F;
        Float height = -1F;
        Integer baseExperience = 10;

        // when
        assertThrows(InvalidPokemonHeightException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenBaseExperienceIsZero_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = 1F;
        Float height = 1F;
        Integer baseExperience = 0;

        // when
        assertThrows(InvalidPokemonBaseExperienceException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    @Test
    void makePokemon_whenBaseExperienceIsNegative_shouldThrowException() {
        // given
        Integer id = 1;
        String name = "Some pokemon";
        Float weight = 1F;
        Float height = 2F;
        Integer baseExperience = -10;

        // when
        assertThrows(InvalidPokemonBaseExperienceException.class, () -> {
            buildPokemon(id, name, weight, height, baseExperience);
        });
    }

    private Pokemon buildPokemon(Integer id, String name, Float weight, Float height, Integer baseExperience) {
        return new Pokemon(
                new PokemonId(id),
                new PokemonName(name),
                new PokemonWeight(weight),
                new PokemonHeight(height),
                new PokemonBaseExperience(baseExperience));
    }
}