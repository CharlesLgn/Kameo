package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

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

  public void addToRole(final Role role) {
    roles.add(role);
  }

  @Override
  public List<Role> roles() {
    return Collections.unmodifiableList(roles);
  }
}
