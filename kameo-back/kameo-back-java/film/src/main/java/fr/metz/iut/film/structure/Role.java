package fr.metz.iut.film.structure;

import java.util.Objects;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import lombok.*;

public final class Role implements PersistentStorage {

  private final String character;
  private final Film film;
  private final Actor actor;


  public Role(final String character, final Film film, final Actor actor) {
    actor.addToRole(this);
    this.character = character;
    this.film = film;
    this.actor = actor;
  }

  @Override
  public String getId() {
    if (film.getId() == null || actor.getId() == null) {
      return null;
    }
    return film.getId() + ";" + actor.getId();
  }

  public String getCharacter() {
    return character;
  }

  public Film getFilm() {
    return film;
  }

  public Actor getActor() {
    return actor;
  }
}
