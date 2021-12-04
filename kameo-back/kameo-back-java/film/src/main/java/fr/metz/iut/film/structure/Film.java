package fr.metz.iut.film.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.film.structure.type.FilmType;

public final class Film implements PersistentStorage {

  private final String id;
  private final String name;
  private final Date releaseDate;
  private final Director director;
  private final String summary;
  private final List<Role> cast;
  private final FilmType typeOfFilm;
  private final double imdbNote;


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

  public List<Role> cast() {
    return Collections.unmodifiableList(cast);
  }

  public void addToCast(String character, Actor actor) {
    cast.add(new Role(character, this, actor));
  }

  public String id() {return id;}

  public String name() {return name;}

  public Date releaseDate() {return releaseDate;}

  public Director director() {return director;}

  public String summary() {return summary;}

  public FilmType typeOfFilm() {return typeOfFilm;}

  public double imdbNote() {return imdbNote;}

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Film) obj;
    return Objects.equals(this.id, that.id) &&
           Objects.equals(this.name, that.name) &&
           Objects.equals(this.releaseDate, that.releaseDate) &&
           Objects.equals(this.director, that.director) &&
           Objects.equals(this.summary, that.summary) &&
           Objects.equals(this.cast, that.cast) &&
           Objects.equals(this.typeOfFilm, that.typeOfFilm) &&
           Double.doubleToLongBits(this.imdbNote) == Double.doubleToLongBits(that.imdbNote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, releaseDate, director, summary, cast, typeOfFilm, imdbNote);
  }

  @Override
  public String toString() {
    return "Film[" +
           "id=" + id + ", " +
           "name=" + name + ", " +
           "releaseDate=" + releaseDate + ", " +
           "director=" + director + ", " +
           "summary=" + summary + ", " +
           "cast=" + cast + ", " +
           "typeOfFilm=" + typeOfFilm + ", " +
           "imdbNote=" + imdbNote + ']';
  }

}
