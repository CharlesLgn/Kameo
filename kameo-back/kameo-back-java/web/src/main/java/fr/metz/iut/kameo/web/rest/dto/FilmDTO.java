package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;
import java.util.Objects;

import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;
import org.springframework.web.client.RestTemplate;

public record FilmDTO(String id,
                      String name,
                      LocalDate releaseDate,
                      String directorId,
                      String summary,
                      FilmType typeOfFilm,
                      String imageUrl) {

  public FilmDTO(final String name, final LocalDate releaseDate, final String directorId, final String summary, final FilmType typeOfFilm) {
    this(null, name, releaseDate, directorId, summary, typeOfFilm, null);
  }

  public static FilmDTO toDTO(Film film) {
    var restTemplate = new RestTemplate();
    var ibdb = restTemplate.getForEntity("https://imdb-api.com/en/API/Title/k_awobkj28/" + film.imbdID(), ImdbImage.class);
    var image = ibdb.hasBody() ? Objects.requireNonNull(ibdb.getBody()).image() : "";
    return new FilmDTO(film.id(), film.name(), film.releaseDate(), film.director().id(), film.summary(), film.typeOfFilm(), image);
  }

  private record ImdbImage(String image) {}
}
