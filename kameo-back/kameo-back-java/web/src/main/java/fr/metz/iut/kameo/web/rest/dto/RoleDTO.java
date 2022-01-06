package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.film.structure.Role;

public record RoleDTO(String character,
                      FilmReferenceDTO film) {

  public RoleDTO(Role role) {
    this(role.character(), new FilmReferenceDTO(role.film()));
  }
}
