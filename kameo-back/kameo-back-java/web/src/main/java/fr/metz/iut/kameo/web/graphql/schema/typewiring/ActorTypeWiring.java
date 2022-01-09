package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.kameo.web.graphql.schema.datafetcher.RoleDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static fr.metz.iut.kameo.web.graphql.schema.datafetcher.RoleDataFetcher.getRolesByActorDataFetcher;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Actor} type.
 */
public class ActorTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Actor")
        .dataFetcher("roles", getRolesByActorDataFetcher())
        .build();
  }
}
