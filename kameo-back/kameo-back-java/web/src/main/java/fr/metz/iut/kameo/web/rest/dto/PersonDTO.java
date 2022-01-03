package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;

import fr.metz.iut.film.structure.*;

public record PersonDTO(String id,
                       String firstName,
                       String lastName,
                       LocalDate birthdate,
                       LocalDate deathDate) {

  public static PersonDTO toDTO(Person person) {
    return new PersonDTO(person.id(), person.firstName(), person.lastName(), person.birthdate(), person.deathDate());
  }
}
