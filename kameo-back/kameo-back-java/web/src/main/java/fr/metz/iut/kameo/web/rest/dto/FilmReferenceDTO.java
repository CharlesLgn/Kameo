package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public record FilmReferenceDTO(String id,
                               String name,
                               Links links) {

  public FilmReferenceDTO(Film film) {
    this(film.id(), film.name(), new Links("/film/" + film.id(), "film", "GET"));
  }
}
