package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.film.structure.type.FilmType;

public record Film(String id,
                   String name,
                   Date releaseDate,
                   Director director,
                   String summary,
                   List<Role> cast,
                   FilmType typeOfFilm,
                   double imdbNote) implements PersistentStorage {

  public Film(final String id, final String name, final Date releaseDate, final Director director, final String summary, final FilmType typeOfFilm, final double imdbNote) {
    this(id, name, releaseDate, director, summary, new ArrayList<>(), typeOfFilm, imdbNote);
  }

  public Film(final String id) {
    this(id, null, null, null, null, null, 0);
  }

  public Film {
    if (director != null){
      director.addToFilm(this);
    }
  }

  @Override
  public List<Role> cast() {
    return Collections.unmodifiableList(cast);
  }

  public void addToCast(String character, Actor actor) {
    cast.add(new Role(character, this, actor));
  }
}
