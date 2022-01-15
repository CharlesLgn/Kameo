package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.type.FilmType;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public record FilmDTO(String id,
                      String name,
                      LocalDate releaseDate,
                      DirectorReferenceDTO director,
                      String summary,
                      FilmType typeOfFilm,
                      ImdbDTO imdb,
                      CastReferenceDTO cast) {

  public FilmDTO(Film film) {
    this(film.id(),
      film.name(),
      film.releaseDate(),
      new DirectorReferenceDTO(film.director()),
      film.summary(),
      film.typeOfFilm(),
      new ImdbDTO(film.imbdID()),
      new CastReferenceDTO(film));
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

  private static final class ImdbDTO {

    private final String image;
    private final double note;

    public ImdbDTO(String imdbId) {
      var restTemplate = new RestTemplate();
      var imdb = restTemplate.getForEntity("https://www.imdb.com/title/" + imdbId + "/", String.class).getBody();
      this.image = setImageLink(imdb);
      this.note = setNote(imdb);
    }

    private String setImageLink(String dom) {
      return Arrays.stream(Objects.requireNonNull(dom).split("<img "))
                   .map(str -> str.split(">")[0])
                   .filter(str -> str.contains("class=\"ipc-image\""))
                   .findFirst()
                   .map(str -> str.split(" src=\"")[1])
                   .map(str -> str.split(" ")[0])
                   .orElse("");
    }

    private double setNote(String dom) {
      return Arrays.stream(Objects.requireNonNull(dom).split("<span "))
                   .map(str -> str.split("</span>")[0])
                   .filter(str -> str.contains("class=\"AggregateRatingButton__RatingScore"))
                   .map(str -> str.split("\">")[1])
                   .mapToDouble(Double::valueOf)
                   .findFirst()
                   .orElse(0.);
    }

    public String getImage() {
      return image;
    }

    public double getNote() {
      return note;
    }
  }
}
