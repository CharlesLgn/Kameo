package fr.metz.iut.kameo.web.graphql.schema.datafetcher;

import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.Role;
import graphql.schema.DataFetcher;

import java.util.List;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Role}.
 */
public class RoleDataFetcher {

  private RoleDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get all {@link Role} of an {@link Actor}.
   */
  public static DataFetcher<List<Role>> getRolesByActorDataFetcher() {
    return env -> {
      Actor actor = env.getSource();
      return actor.roles();
    };
  }

  public static DataFetcher<List<Role>> getRolesByFilmDataFetcher() {
    return env -> {
      Film film = env.getSource();
      return film.cast();
    };
  }
}
