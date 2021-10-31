package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

/**
 * Represent a director.
 * An director is a {@link Person} that creates {@link Film}.
 *
 * For instance Quentin Tarantino is a director that made Kill bill and once upon a time in hollywood.
 * We can represent like in the test class {@link TestDirector}
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
    this(id, firstName, lastName, birthdate, null, new ArrayList<>());
  }

  public void addToFilm(final Film film) {
    films.add(film);
  }

  @Override
  public List<Film> films() {
    return Collections.unmodifiableList(films);
  }
}
