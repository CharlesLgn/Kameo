package fr.metz.iut.film.structure;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import lombok.*;

@Getter
@AllArgsConstructor
public final class Role implements PersistentStorage {

  @Getter private final String character;
  @Getter private final Film film;
  @Getter private final Actor actor;

  @Override
  public String getId() {
    if (film.getId() == null || actor.getId() == null) {
      return null;
    }
    return film.getId() + ";" + actor.getId();
  }
}
