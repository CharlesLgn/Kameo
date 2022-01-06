package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.film.structure.Director;

import java.time.LocalDate;

public record DirectorDTO(String id,
                          String firstName,
                          String lastName,
                          LocalDate birthdate,
                          LocalDate deathDate,
                          FilmsDTO films) {

  public DirectorDTO(Director person) {
    this(person.id(),
      person.firstName(),
      person.lastName(),
      person.birthdate(),
      person.deathDate(),
      new FilmsDTO(new Links("/director/" + person.id() + "/films", "film", "GET")));
  }

  private record FilmsDTO(Links links) {}
}
