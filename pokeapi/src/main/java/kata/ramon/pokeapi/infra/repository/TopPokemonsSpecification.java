package kata.ramon.pokeapi.infra.repository;

import kata.ramon.pokeapi.domain.Pokemon;
import kata.ramon.pokeapi.infra.repository.dao.PokemonDAO;
import org.springframework.data.jpa.domain.Specification;

public class TopPokemonsSpecification {

    public static Specification<PokemonDAO> orderBy(String criteria, String gameVersion) {
        return (root, criteriaQuery, builder) ->
        {
            criteriaQuery.orderBy(builder.desc(root.get(criteria)));
            return builder.equal(root.get("gameVersion"), gameVersion);
        };
    }
}
