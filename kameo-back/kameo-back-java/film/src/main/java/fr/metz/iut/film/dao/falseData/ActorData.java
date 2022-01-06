package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.Actor;

import java.time.LocalDate;
import java.time.Month;

import static fr.metz.iut.crud.GenerateID.generateNewId;

class ActorData {

  static final Actor EDWARD_NORTON     = new Actor(generateNewId(), "Edward",  "Norton",     LocalDate.of(1969, Month.AUGUST, 18), null);
  static final Actor BRAD_PITT         = new Actor(generateNewId(), "Brad",    "Pitt",       LocalDate.of(1963, Month.DECEMBER, 18), null);
  static final Actor KANG_HO_SONG      = new Actor(generateNewId(),  "Kang-ho", "Song",      LocalDate.of(1967, Month.JANUARY, 17), null);
  static final Actor JUSTIN_TIMBERLAKE = new Actor(generateNewId(),  "Justin", "Timberlake", LocalDate.of(1981, Month.JANUARY, 31), null);
  static final Actor ANDREW_GARFIELD   = new Actor(generateNewId(),  "Andrew", "Garfield",   LocalDate.of(1983, Month.AUGUST, 20), null);
  static final Actor JESSE_EISENBERG   = new Actor(generateNewId(),  "Jesse", "Eisenberg",   LocalDate.of(1983, Month.OCTOBER, 5), null);
  static final Actor LEONARDO_DICAPRIO = new Actor(generateNewId(),  "Leonardo", "DiCaprio", LocalDate.of(1974, Month.NOVEMBER, 11), null);
  static final Actor MARGOT_ROBBIE     = new Actor(generateNewId(),  "Margot", "Robbie",     LocalDate.of(1990, Month.JULY, 2), null);
  static final Actor LI_JUN_LI         = new Actor(generateNewId(),  "Li", "Jun Li",         null, null);
  static final Actor EMMA_STONE        = new Actor(generateNewId(),  "Emma", "Stone",        LocalDate.of(1988, Month.NOVEMBER, 6), null);
  static final Actor RYAN_GOSLING      = new Actor(generateNewId(),  "Ryan", "Gosling",      LocalDate.of(1980, Month.NOVEMBER, 12), null);
  static final Actor ELLIOT_PAGE       = new Actor(generateNewId(),  "Elliot", "Page",       LocalDate.of(1987, Month.FEBRUARY, 21), null);

}
