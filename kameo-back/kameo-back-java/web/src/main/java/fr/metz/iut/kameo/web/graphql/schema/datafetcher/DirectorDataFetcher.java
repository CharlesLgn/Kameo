package fr.metz.iut.kameo.web.graphql.schema.datafetcher;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import graphql.schema.DataFetcher;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Director}.
 */
public class DirectorDataFetcher {

  private DirectorDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get the {@link Director} from a {@link Film}.
   */
  public static DataFetcher<Director> getDirectorByFilmDataFetcher() {
    return env -> {
      Film film = env.getSource();
      return film.director();
    };
  }

  /**
   * data fetcher to get the {@link Director} in the data base matching the id..
   */
  public static DataFetcher<Director> getDirectorByIdDataFetcher() {
    return env -> Load.get().load(Director.class, env.getArgument("id"));
  }
}
