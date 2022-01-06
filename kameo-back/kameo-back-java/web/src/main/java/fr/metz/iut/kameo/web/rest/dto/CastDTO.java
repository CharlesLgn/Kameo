package fr.metz.iut.kameo.web.rest.dto;

import fr.metz.iut.film.structure.Role;

public record CastDTO(String character,
                      ActorReferenceDTO actor) {

  public CastDTO(Role role) {
    this(role.character(), new ActorReferenceDTO(role.actor().id()));
  }

  private record ActorReferenceDTO(String id, Links links) {
    private ActorReferenceDTO(String id) {
      this(id, new Links("/actor/" + id, "actor", "GET"));
    }
  }
}
