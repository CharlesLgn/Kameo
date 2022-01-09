package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.ActorDataFetcher.getActorsByIdDataFetcher;
import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.DirectorDataFetcher.getDirectorByIdDataFetcher;
import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.FilmDataFetcher.getFilmByIdDataFetcher;
import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.FilmDataFetcher.getFilmsDataFetcher;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers for all queries.
 */
public class QueryTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Query")
        .dataFetcher("films",    getFilmsDataFetcher())
        .dataFetcher("film",     getFilmByIdDataFetcher())
        .dataFetcher("director", getDirectorByIdDataFetcher())
        .dataFetcher("actor",    getActorsByIdDataFetcher())
        .build();
  }
}
