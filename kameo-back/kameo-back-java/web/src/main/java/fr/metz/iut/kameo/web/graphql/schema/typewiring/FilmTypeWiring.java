package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.film.structure.Film;
import fr.metz.iut.kameo.web.graphql.schema.datafetcher.DirectorDataFetcher;
import fr.metz.iut.kameo.web.graphql.schema.datafetcher.ImdbDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.RoleDataFetcher.getRolesByFilmDataFetcher;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Film} type.
 */
public class FilmTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Film")
        .dataFetcher("cast", getRolesByFilmDataFetcher())
        .dataFetcher("director", DirectorDataFetcher.getDirectorByFilmDataFetcher())
        .dataFetcher("imdb", ImdbDataFetcher.getImdbByFilmDataFetcher())
        .build();
  }
}
