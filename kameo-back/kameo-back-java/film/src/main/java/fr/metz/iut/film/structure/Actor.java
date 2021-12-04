package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

/**
 * Represent an actor.
 * An actor is a {@link Person} that have {@link Role roles} in {@link Film films}.
 */
public final class Actor implements Person, PersistentStorage {

  private final String id;
  private final String firstName;
  private final String lastName;
  private final Date birthdate;
  private final Date deathDate;
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

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public Date getDeathDate() {
    return deathDate;
  }

  public List<Role> getRoles() {
    return Collections.unmodifiableList(roles);
  }
}
