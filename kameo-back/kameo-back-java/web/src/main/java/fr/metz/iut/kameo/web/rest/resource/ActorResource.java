package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.kameo.web.rest.dto.PersonDTO;
import fr.metz.iut.kameo.web.rest.dto.RoleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorResource {

  @GetMapping("/actor/{id}")
  public PersonDTO actorById(@PathVariable(value = "id") String id) {
    return PersonDTO.toDTO(Load.get().load(Actor.class, id));
  }

  @GetMapping("/actor/{id}/roles")
  public List<RoleDTO> roleByActor(@PathVariable(value = "id") String id) {
    return Load.get().load(Actor.class, id)
               .roles()
               .stream()
               .map(RoleDTO::toDTO)
               .toList();

  }
}
