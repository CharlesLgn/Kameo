package fr.metz.iut.film.structure;

import java.util.Date;

/**
 * Represent a person.
 * It can be a {@link Director} meaning that he makes {@link Film}
 * or an {@link Actor} meaning that he can have a {@link Role} in a {@link Film}
 */
public interface Person {

  String id();
  String firstName();
  String lastName();
  Date birthdate();
  Date deathDate();
}
