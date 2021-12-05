package fr.metz.iut.film.structure;

import fr.metz.iut.dataacces.PersistentStorage;

public record Role(String character,
                   Film film,
                   Actor actor) implements PersistentStorage {

  @Override
  public String getId() {
    if (film.getId() == null || actor.getId() == null) {
      return null;
    }
    return film.getId() + ";" + actor.getId();
  }
}
