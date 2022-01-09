package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.kameo.web.graphql.schema.datafetcher.FilmDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers for all mutations.
 */
public class MutationTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Mutation")
        .dataFetcher("createFilm", FilmDataFetcher.createFilmDataFetcher())
        .build();
  }
}
