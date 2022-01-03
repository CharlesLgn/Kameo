package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;

import java.time.LocalDate;

public record FilmDTOCreate(String id,
                            String name,
                            LocalDate releaseDate,
                            String directorId,
                            String summary,
                            FilmType typeOfFilm,
                            String imdbID) {

  public Film toFilm() {
    return new Film(id, name, releaseDate, Load.get().load(Director.class, directorId), summary, typeOfFilm, imdbID);
  }
}
