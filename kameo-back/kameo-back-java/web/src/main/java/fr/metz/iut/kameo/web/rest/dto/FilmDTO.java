package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;

import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;

public record FilmDTO(String id,
                      String name,
                      LocalDate releaseDate,
                      String directorId,
                      String summary,
                      FilmType typeOfFilm) {

  public FilmDTO(final String name, final LocalDate releaseDate, final String directorId, final String summary, final FilmType typeOfFilm) {
    this(null, name, releaseDate, directorId, summary, typeOfFilm);
  }

  public static FilmDTO toDTO(Film film) {
    return new FilmDTO(film.id(), film.name(), film.releaseDate(), film.director().id(), film.summary(), film.typeOfFilm());
  }
}
