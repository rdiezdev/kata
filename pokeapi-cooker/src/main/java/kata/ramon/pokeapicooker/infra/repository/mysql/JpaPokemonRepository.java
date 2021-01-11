package kata.ramon.pokeapicooker.infra.repository.mysql;

import kata.ramon.pokeapicooker.infra.repository.mysql.dao.PokemonDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPokemonRepository extends JpaRepository<PokemonDAO, Integer> {
    Optional<PokemonDAO> findByName(String name);
}
