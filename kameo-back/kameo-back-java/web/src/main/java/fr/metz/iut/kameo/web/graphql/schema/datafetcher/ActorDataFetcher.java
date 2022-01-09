package fr.metz.iut.kameo.web.graphql.schema.datafetcher;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Actor;
import graphql.schema.DataFetcher;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Actor}.
 */
public class ActorDataFetcher {

  private ActorDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get the {@link Actor} in the data base matching the id.
   */
  public static DataFetcher<Actor> getActorsByIdDataFetcher() {
    return env -> Load.get().load(Actor.class, env.getArgument("id"));
  }
}
