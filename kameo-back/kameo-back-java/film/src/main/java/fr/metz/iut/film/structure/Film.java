package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.film.structure.type.FilmType;
import lombok.Getter;

public final class Film implements PersistentStorage {

  @Getter private final String id;
  @Getter private final String name;
  @Getter private final Date releaseDate;
  @Getter private final Director director;
  @Getter private final String summary;
  private final List<Role> cast;
  @Getter private final FilmType typeOfFilm;
  @Getter private final double imdbNote;


  public Film(final String id, final String name, final Date releaseDate, final Director director, final String summary, final FilmType typeOfFilm, final double imdbNote) {
    this(id, name, releaseDate, director, summary, new ArrayList<>(), typeOfFilm, imdbNote);
  }

  public Film(final String id) {
    this(id, null, null, null, null, null, 0);
  }

  public Film(final String id, final String name, final Date releaseDate, final Director director, final String summary, final List<Role> cast, final FilmType typeOfFilm, final double imdbNote) {
    if (director != null) {
      director.addToFilm(this);
    }
    this.id = id;
    this.name = name;
    this.releaseDate = releaseDate;
    this.director = director;
    this.summary = summary;
    this.cast = cast;
    this.typeOfFilm = typeOfFilm;
    this.imdbNote = imdbNote;
  }

  public List<Role> getCast() {
    return Collections.unmodifiableList(cast);
  }

  public void addToCast(String character, Actor actor) {
    cast.add(new Role(character, this, actor));
  }
}
