package kata.ramon.pokeapi.infra.repository;

import kata.ramon.pokeapi.domain.Pokemon;
import kata.ramon.pokeapi.domain.repository.PokemonRepository;
import kata.ramon.pokeapi.domain.vo.PokemonBaseExperience;
import kata.ramon.pokeapi.domain.vo.PokemonHeight;
import kata.ramon.pokeapi.domain.vo.PokemonId;
import kata.ramon.pokeapi.domain.vo.PokemonName;
import kata.ramon.pokeapi.domain.vo.PokemonWeight;
import kata.ramon.pokeapi.infra.repository.dao.PokemonDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MysqlPokemonRepository implements PokemonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pokemon> topHeaviest(Integer rankSize) {
        return entityManager.createQuery("SELECT p FROM pokemon p ORDER BY p.weight DESC ", PokemonDAO.class)
                .setMaxResults(rankSize)
                .getResultList()
                .stream()
                .map(pokemonDAO -> new Pokemon(
                        new PokemonId(pokemonDAO.getId()),
                        new PokemonName(pokemonDAO.getName()),
                        new PokemonWeight(pokemonDAO.getWeight()),
                        new PokemonHeight(pokemonDAO.getHeight()),
                        new PokemonBaseExperience(pokemonDAO.getBaseExperience()))
                ).collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> topHighest(Integer rankSize) {
        return entityManager.createQuery("SELECT p FROM pokemon p ORDER BY p.height DESC", PokemonDAO.class)
                .setMaxResults(rankSize)
                .getResultList()
                .stream()
                .map(pokemonDAO -> new Pokemon(
                        new PokemonId(pokemonDAO.getId()),
                        new PokemonName(pokemonDAO.getName()),
                        new PokemonWeight(pokemonDAO.getWeight()),
                        new PokemonHeight(pokemonDAO.getHeight()),
                        new PokemonBaseExperience(pokemonDAO.getBaseExperience()))
                ).collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> topGreatestBaseExperience(Integer rankSize) {
        return entityManager.createQuery("SELECT p FROM pokemon p ORDER BY p.baseExperience DESC", PokemonDAO.class)
                .setMaxResults(rankSize)
                .getResultList()
                .stream()
                .map(pokemonDAO -> new Pokemon(
                        new PokemonId(pokemonDAO.getId()),
                        new PokemonName(pokemonDAO.getName()),
                        new PokemonWeight(pokemonDAO.getWeight()),
                        new PokemonHeight(pokemonDAO.getHeight()),
                        new PokemonBaseExperience(pokemonDAO.getBaseExperience()))
                ).collect(Collectors.toList());
    }
}
