package fr.metz.iut.film.structure;

import fr.metz.iut.dataacces.PersistentStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Represent a director.
 * An director is a {@link Person} that creates {@link Film}.
 * <p>
 * For instance Quentin Tarantino is a director that made Kill bill and once upon a time in hollywood.
 */
public record Director(String id,
                       String firstName,
                       String lastName,
                       Date birthdate,
                       Date deathDate,
                       List<Film> films) implements Person, PersistentStorage {

  public Director(String id, String firstName, String lastName, Date birthdate, Date deathDate) {
    this(id, firstName, lastName, birthdate, deathDate, new ArrayList<>());
  }

  public Director(String id, String firstName, String lastName, Date birthdate) {
    this(id, firstName, lastName, birthdate, null);
  }

  public void addToFilm(final Film film) {
    films.add(film);
  }

  public List<Film> getFilms() {
    return Collections.unmodifiableList(films);
  }

  @Override
  public String getId() {
    return id;
  }
}
