package fr.metz.iut.film.structure;

import java.time.LocalDate;
import java.util.*;

import fr.metz.iut.dataacces.PersistentStorage;
import fr.metz.iut.film.structure.type.FilmType;

public record Film(String id,
                   String name,
                   LocalDate releaseDate,
                   Director director,
                   String summary,
                   List<Role> cast,
                   FilmType typeOfFilm,
                   String imbdID) implements PersistentStorage {

  public Film {
    if (director != null) {
      director.addToFilm(this);
    }
  }

  public Film(final String id, final String name, final LocalDate releaseDate, final Director director, final String summary, final FilmType typeOfFilm, final String imbdID) {
    this(id, name, releaseDate, director, summary, new ArrayList<>(), typeOfFilm, imbdID);
  }

  @Override
  public List<Role> cast() {
    return Collections.unmodifiableList(cast);
  }

  public void addToCast(String character, Actor actor) {
    cast.add(new Role(character, this, actor));
  }

  @Override
  public String getId() {
    return id;
  }
}
