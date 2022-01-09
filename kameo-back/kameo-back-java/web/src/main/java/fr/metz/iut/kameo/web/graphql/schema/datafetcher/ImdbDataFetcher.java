package fr.metz.iut.kameo.web.graphql.schema.datafetcher;

import fr.metz.iut.film.structure.Film;
import graphql.schema.DataFetcher;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

public class ImdbDataFetcher {

  public static DataFetcher<Imdb> getImdbByFilmDataFetcher() {
    return env -> {
      Film film = env.getSource();
      return new Imdb(film.imbdID());
    };
  }

  private static final class Imdb {

    private final String image;
    private final double note;

    public Imdb(String imdbId) {
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
                   .map(str -> str.split("\"")[0])
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
