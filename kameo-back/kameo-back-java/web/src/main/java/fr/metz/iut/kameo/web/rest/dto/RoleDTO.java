package fr.metz.iut.kameo.web.rest.dto;

import java.time.LocalDate;

import fr.metz.iut.film.structure.*;
import fr.metz.iut.film.structure.type.FilmType;

public record RoleDTO(String character,
                      String filmId,
                      String actorId) {

  public static RoleDTO toDTO(Role role) {
    return new RoleDTO(role.character(), role.film().id(), role.actor().id());
  }
}
