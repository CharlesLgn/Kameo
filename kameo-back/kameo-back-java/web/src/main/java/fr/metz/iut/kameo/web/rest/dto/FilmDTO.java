package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;

import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;
import org.springframework.web.client.RestTemplate;

public record FilmDTO(String id,
                      String name,
                      LocalDate releaseDate,
                      DirectorReferenceDTO director,
                      String summary,
                      FilmType typeOfFilm,
                      String imageUrl,
                      CastReferenceDTO cast) {

  public FilmDTO(Film film) {
    this(film.id(),
      film.name(),
      film.releaseDate(),
      new DirectorReferenceDTO(film.director()),
      film.summary(),
      film.typeOfFilm(),
      getImageLink(film),
      new CastReferenceDTO(film));
  }

  private static String getImageLink(Film film) {
    // var restTemplate = new RestTemplate();
    // var ibdb = restTemplate.getForEntity("https://imdb-api.com/en/API/Title/k_awobkj28/" + film.imbdID(), ImdbImage.class);
    // return ibdb.hasBody() ? Objects.requireNonNull(ibdb.getBody()).image() : "";
    return "https://fr.web.img6.acsta.net/pictures/210/604/21060483_20131125114549726.jpg";
  }

  public record DirectorReferenceDTO(String id, Links links) {

    public DirectorReferenceDTO(Director director) {
      this(director.id(), new Links("/director/" + director.id(), "director", "GET"));
    }
  }

  public record CastReferenceDTO(Links links) {

    public CastReferenceDTO(Film film) {
      this(new Links("/film/" + film.id() + "/cast", "cast", "GET"));
    }
  }
}
