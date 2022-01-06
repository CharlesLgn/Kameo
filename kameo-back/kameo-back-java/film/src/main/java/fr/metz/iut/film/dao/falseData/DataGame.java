package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.film.structure.Person;
import fr.metz.iut.film.structure.type.FilmType;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static fr.metz.iut.crud.GenerateID.generateNewId;
import static fr.metz.iut.film.dao.falseData.ActorData.*;
import static fr.metz.iut.film.dao.falseData.DirectorData.*;
import static fr.metz.iut.film.dao.falseData.FilmData.*;
import static java.util.Arrays.asList;

/**
 * to have a data game.
 * it's because it is an exemple that doeesn't need any database.
 * In a real project, please, don't do this
 */
public class DataGame {

  private static final List<Film> FILMS = Arrays.asList(FIGHT_CLUB,
    THE_SOCIAL_NETWORK,
    BABYLON,
    LA_LA_LAND,
    INCEPTION,
    INTERSTELLAR,
    TENET,
    PULP_FICTION,
    ONCE_UPON_A_TIME_IN_HOLLYWOOD,
    PARASITE
  );
  private static final List<Person> PEOPLE = Arrays.asList(DAMIEN_CHAZELLE, DAVID_FINCHER, CHRISTOPHER_NOLAN, QUENTIN_TARANTINO, BONG_JOON_HO,
    BRAD_PITT, EDWARD_NORTON, KANG_HO_SONG);

  static {
    EDWARD_NORTON.addToRole(FIGHT_CLUB, "Narator");
    BRAD_PITT.addToRole(FIGHT_CLUB, "Tyle Durden");
    BRAD_PITT.addToRole(ONCE_UPON_A_TIME_IN_HOLLYWOOD, "Cliff Booth");
    KANG_HO_SONG.addToRole(PARASITE, "Ki Taek");
  }

  public static List<Film> getFilms() {
    return FILMS;
  }

  public static List<Person> getPeople() {
    return PEOPLE;
  }
}
