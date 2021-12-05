package fr.metz.iut.film.structure;

import fr.metz.iut.dataacces.PersistentStorage;

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
                    Date birthdate,
                    Date deathDate,
                    List<Role> roles) implements Person, PersistentStorage {

  public Actor(String id, String firstName, String lastName, Date birthdate, Date deathDate) {
    this(id, firstName, lastName, birthdate, deathDate, new ArrayList<>());
  }

  @Override
  public String getId() {
    return id;
  }

  public void addToRole(final Role role) {
    roles.add(role);
  }

  public List<Role> getRoles() {
    return Collections.unmodifiableList(roles);
  }
}
