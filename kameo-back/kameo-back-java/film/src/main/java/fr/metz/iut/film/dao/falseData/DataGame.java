package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.*;
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
    new Role("Narator",             FIGHT_CLUB,                    EDWARD_NORTON);
    new Role("Tyle Durden",         FIGHT_CLUB,                    BRAD_PITT);
    new Role("Ki Taek",             PARASITE,                      KANG_HO_SONG);
    new Role("Sean Parker",         THE_SOCIAL_NETWORK,            JUSTIN_TIMBERLAKE);
    new Role("Eduardo Saverin",     THE_SOCIAL_NETWORK,            ANDREW_GARFIELD);
    new Role("Mark Zuckerberg",     THE_SOCIAL_NETWORK,            JESSE_EISENBERG);
    new Role("Cliff Booth",         ONCE_UPON_A_TIME_IN_HOLLYWOOD, BRAD_PITT);
    new Role("Rick Dalton",         ONCE_UPON_A_TIME_IN_HOLLYWOOD, LEONARDO_DICAPRIO);
    new Role("Sharon Tate",         ONCE_UPON_A_TIME_IN_HOLLYWOOD, MARGOT_ROBBIE);
    new Role("",                    BABYLON,                       BRAD_PITT);
    new Role("Clara Bow",           BABYLON,                       MARGOT_ROBBIE);
    new Role("Anna May Wong",       BABYLON,                       LI_JUN_LI);
    new Role("Sebastian Wilder",    LA_LA_LAND,                    EMMA_STONE);
    new Role("Mia Dolan",           LA_LA_LAND,                    RYAN_GOSLING);
    new Role("Ariane",              INCEPTION,                     ELLIOT_PAGE);
    new Role("Dominic « Dom » Cobb",INCEPTION,                     LEONARDO_DICAPRIO);
  }

  public static List<Film> getFilms() {
    return FILMS;
  }

  public static List<Person> getPeople() {
    return PEOPLE;
  }
}
