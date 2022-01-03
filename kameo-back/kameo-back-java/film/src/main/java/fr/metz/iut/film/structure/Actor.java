package fr.metz.iut.film.structure;

import fr.metz.iut.dataacces.PersistentStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Represent an actor.
 * An actor is a {@link Person} that have {@link Role roles} in {@link Film films}.
 */
public record Actor(String id,
                    String firstName,
                    String lastName,
                    LocalDate birthdate,
                    LocalDate deathDate,
                    List<Role> roles) implements Person, PersistentStorage {

  public Actor(String id, String firstName, String lastName, LocalDate birthdate, LocalDate deathDate) {
    this(id, firstName, lastName, birthdate, deathDate, new ArrayList<>());
  }

  @Override
  public String getId() {
    return id;
  }

  public void addToRole(final Film film, final String role) {
    roles.add(new Role(role, film, this));
  }

  public List<Role> getRoles() {
    return Collections.unmodifiableList(roles);
  }
}
