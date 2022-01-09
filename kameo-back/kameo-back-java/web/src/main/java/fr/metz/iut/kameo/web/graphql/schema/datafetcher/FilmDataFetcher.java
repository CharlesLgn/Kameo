package fr.metz.iut.kameo.web.graphql.schema.datafetcher;

import fr.metz.iut.crud.Load;
import fr.metz.iut.crud.Save;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.Role;
import fr.metz.iut.kameo.web.graphql.schema.input.FilmInput;
import graphql.schema.DataFetcher;

import java.util.List;

import static fr.metz.iut.crud.GenerateID.generateNewId;

/**
 * Repository of all data fetchers responsible
 * for returning one or multiple {@link Film}.
 */
public class FilmDataFetcher {

  private FilmDataFetcher() {
    throw new IllegalAccessError("cannot be instantiate");
  }

  /**
   * data fetcher to get a {@link Film in the data base matching the id.
   */
  public static DataFetcher<Film> getFilmByIdDataFetcher() {
    return env -> Load.get().load(Film.class, env.getArgument("id"));
  }

  /**
   * data fetcher to get all {@link Film} in the data base.
   */
  public static DataFetcher<List<Film>> getFilmsDataFetcher() {
    return env -> Load.get().loadAll(Film.class);
  }

  /**
   * data fetcher to get all {@link Film} from a {@link Director}.
   */
  public static DataFetcher<List<Film>> getFilmByDirectorDataFetcher() {
    return env -> {
      Director director = env.getSource();
      return director.films();
    };
  }

  /**
   * data fetcher to get a {@link Film} from a {@link Role}.
   */
  public static DataFetcher<Film> getFilmByRoleDataFetcher() {
    return env -> {
      Role role = env.getSource();
      return role.film();
    };
  }

  /**
   * data fetcher to create a {@link Film} and return it.
   */
  public static DataFetcher<Film> createFilmDataFetcher() {
    return env -> {
      FilmInput input = env.getArgument("film");
      Film film = new Film(generateNewId(),
        input.name(),
        input.releaseDate(),
        Load.get().load(Director.class, input.directorId()),
        input.summary(),
        input.typeOfFilm(),
        input.imdbID());
      Save.get().save(film);
      return film;
    };
  }
}
