package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.Director;

import java.time.LocalDate;
import java.time.Month;

import static fr.metz.iut.crud.GenerateID.generateNewId;

class DirectorData {

  static final Director DAMIEN_CHAZELLE   = new Director(generateNewId(), "Damien",      "Chazelle",  LocalDate.of(1985, Month.JANUARY,   19), null);
  static final Director DAVID_FINCHER     = new Director(generateNewId(), "David",       "Fincher",   LocalDate.of(1962, Month.AUGUST,    28), null);
  static final Director CHRISTOPHER_NOLAN = new Director(generateNewId(), "Christopher", "Nolan",     LocalDate.of(1970, Month.JULY,      30), null);
  static final Director QUENTIN_TARANTINO = new Director(generateNewId(), "Quentin",     "Tarantino", LocalDate.of(1963, Month.MARCH,     27), null);
  static final Director BONG_JOON_HO      = new Director(generateNewId(), "Bong",        "Joon-ho",   LocalDate.of(1969, Month.SEPTEMBER, 14), null);

}
