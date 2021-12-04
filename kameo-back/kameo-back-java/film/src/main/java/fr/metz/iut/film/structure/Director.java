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
public final class Director implements Person, PersistentStorage {

  private final String id;
  private final String firstName;
  private final String lastName;
  private final Date birthdate;
  private final Date deathDate;
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

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public Date getBirthdate() {
    return birthdate;
  }

  @Override
  public Date getDeathDate() {
    return deathDate;
  }
}
