package fr.metz.iut.kameo.web.falsedata;

import static java.util.Arrays.asList;

import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import fr.metz.iut.film.structure.*;
import fr.metz.iut.film.structure.type.FilmType;

/**
 * to have a data game.
 * it's because it is an exemple that doeesn't need any database.
 * In a real project, please, don't do this
 */
public class DataGame {

  private static final AtomicInteger ID = new AtomicInteger();

  private static final List<Film> FILMS = new ArrayList<>();
  private static final List<Person> PEOPLE = new ArrayList<>();

  public static String generateNewId() {
    return Integer.toString(ID.getAndIncrement());
  }

  static {
    Actor edwardNorton = new Actor(generateNewId(), "Edward", "Norton", LocalDate.of(1969, Month.AUGUST, 18), null);
    Actor bradPitt = new Actor(generateNewId(), "Brad", "Pitt", LocalDate.of(1963, Month.DECEMBER, 18), null);

    Director damienChazelle = new Director(generateNewId(), "Damien", "Chazelle", LocalDate.of(1985, Month.JANUARY, 19), null);
    Director davidFincher = new Director(generateNewId(),"David", "Fincher", LocalDate.of(1962, Month.AUGUST, 28), null);

    Film fightClub = new Film(
      generateNewId(),
      "Fight Club",
      LocalDate.of(1999, Month.SEPTEMBER, 10),
      davidFincher,
      """
      Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.
      Face à la vacuité de son existence, son médecin lui conseille de suivre une thérapie afin de relativiser son mal-être.
      Lors d'un voyage d'affaires, il fait la connaissance de Tyler Durden, une sorte de gourou anarchiste et philosophe.
      Ensemble, ils fondent le Fight Club.Cercle très fermé, où ils organisent des combats clandestins et violents, destinés à évacuer l'ordre établi.""",
      FilmType.ACTION,
      8.8);
    Film babylon = new Film(generateNewId(),
      "Babylon",
      LocalDate.of(2022, Month.DECEMBER, 25),
      damienChazelle,
      "Un drame situé à Hollywood, durant l'apparition du cinéma parlant.",
      FilmType.ROMANCE,
      -1);

    FILMS.addAll(asList(fightClub, babylon));
    PEOPLE.addAll(asList(edwardNorton, bradPitt, damienChazelle, davidFincher));
    edwardNorton.addToRole(fightClub, "Narator");
    bradPitt.addToRole(fightClub, "Tyle Durden");
    bradPitt.addToRole(babylon, "Unknown");
  }

  public static List<Film> getFilms() {
    return FILMS;
  }

  public static List<Person> getPeople() {
    return PEOPLE;
  }
}
