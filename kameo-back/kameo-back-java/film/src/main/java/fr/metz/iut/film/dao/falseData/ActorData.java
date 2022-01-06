package fr.metz.iut.film.dao.falseData;

import fr.metz.iut.film.structure.Actor;

import java.time.LocalDate;
import java.time.Month;

import static fr.metz.iut.crud.GenerateID.generateNewId;

class ActorData {

  static final Actor EDWARD_NORTON = new Actor(generateNewId(), "Edward",  "Norton", LocalDate.of(1969, Month.AUGUST, 18), null);
  static final Actor BRAD_PITT     = new Actor(generateNewId(), "Brad",    "Pitt",   LocalDate.of(1963, Month.DECEMBER, 18), null);
  static final Actor KANG_HO_SONG = new Actor(generateNewId(),  "Kang-ho", "Song",   LocalDate.of(1967, Month.JANUARY, 17), null);

}
