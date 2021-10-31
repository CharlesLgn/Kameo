package fr.metz.iut.film.structure;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

public record Role(String character, Film film, Actor actor) implements PersistentStorage {

  public Role {
    actor.addToRole(this);
  }
}
