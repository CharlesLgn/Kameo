package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.film.structure.Role;
import fr.metz.iut.kameo.web.graphql.schema.datafetcher.FilmDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Role} type.
 */
public class RoleTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Role")
        .dataFetcher("film", FilmDataFetcher.getFilmByRoleDataFetcher())
        .build();
  }
}
