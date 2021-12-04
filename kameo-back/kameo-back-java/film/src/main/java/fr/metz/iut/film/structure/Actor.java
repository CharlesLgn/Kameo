package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import lombok.Getter;

/**
 * Represent an actor.
 * An actor is a {@link Person} that have {@link Role roles} in {@link Film films}.
 */
public final class Actor implements Person, PersistentStorage {

  @Getter private final String id;
  @Getter private final String firstName;
  @Getter private final String lastName;
  @Getter private final Date birthdate;
  @Getter private final Date deathDate;
  private final List<Role> roles = new ArrayList<>();

  /**
   */
  public Actor(String id,
               String firstName,
               String lastName,
               Date birthdate,
               Date deathDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.deathDate = deathDate;
  }

  public void addToRole(final Role role) {
    roles.add(role);
  }

  public List<Role> getRoles() {
    return Collections.unmodifiableList(roles);
  }
}
