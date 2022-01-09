package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.film.structure.Director;
import fr.metz.iut.kameo.web.graphql.schema.datafetcher.FilmDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Director} type.
 */
public class DirectorTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Director")
        .dataFetcher("films", FilmDataFetcher.getFilmByDirectorDataFetcher())
        .build();
  }
}
