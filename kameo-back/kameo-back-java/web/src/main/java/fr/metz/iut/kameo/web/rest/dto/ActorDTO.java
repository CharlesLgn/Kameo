package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;

import fr.metz.iut.film.structure.*;

public record ActorDTO(String id,
                       String firstName,
                       String lastName,
                       LocalDate birthdate,
                       LocalDate deathDate,
                       RolesReferenceDTO roles) {

  public ActorDTO(Actor person) {
    this(person.id(),
      person.firstName(),
      person.lastName(),
      person.birthdate(),
      person.deathDate(),
      new RolesReferenceDTO(new Links("/actor/" + person.id() + "/roles", "role", "GET")));
  }

  private record RolesReferenceDTO(Links links) {}
}
