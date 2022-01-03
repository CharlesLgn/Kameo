package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.kameo.web.falsedata.DataGame;
import fr.metz.iut.kameo.web.rest.dto.PersonDTO;
import fr.metz.iut.kameo.web.rest.dto.RoleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ActorResource {

  @GetMapping("/actor/{id}")
  public PersonDTO actorById(@PathVariable(value = "id") String id) {
    return DataGame.getPeople().stream()
                   .filter(Actor.class::isInstance)
                   .filter(person -> id.equals(person.id()))
                   .map(PersonDTO::toDTO)
                   .findFirst()
                   .orElse(null);
  }

  @GetMapping("/actor/{id}/roles")
  public List<RoleDTO> roleByActor(@PathVariable(value = "id") String id) {
    return DataGame.getPeople().stream()
                   .filter(Actor.class::isInstance)
                   .filter(person -> id.equals(person.id()))
                   .map(Actor.class::cast)
                   .map(Actor::roles)
                   .flatMap(Collection::stream)
                   .map(RoleDTO::toDTO)
                   .toList();
  }
}
