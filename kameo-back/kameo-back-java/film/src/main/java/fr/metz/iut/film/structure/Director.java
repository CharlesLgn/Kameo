package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import lombok.Getter;

/**
 * Represent a director.
 * An director is a {@link Person} that creates {@link Film}.
 *
 * For instance Quentin Tarantino is a director that made Kill bill and once upon a time in hollywood.
 * We can represent like in the test class {@link TestDirector}
 */
public final class Director implements Person, PersistentStorage {

  @Getter private final String id;
  @Getter private final String firstName;
  @Getter private final String lastName;
  @Getter private final Date birthdate;
  @Getter private final Date deathDate;
  private final List<Film> films= new ArrayList<>();

  /**
   */
  public Director(String id, String firstName, String lastName, Date birthdate, Date deathDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.deathDate = deathDate;
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
}
