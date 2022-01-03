package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.kameo.web.rest.dto.RoleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleResource {

  @GetMapping("/film/{id}/cast")
  public List<RoleDTO> castByFilm(@PathVariable(value = "id") String id) {
    return Load.get().load(Film.class, id)
               .cast()
               .stream()
               .map(RoleDTO::toDTO)
               .toList();
  }

  @GetMapping("/actor/{id}/cast")
  public List<RoleDTO> castByActor(@PathVariable(value = "id") String id) {
    return Load.get().load(Actor.class, id)
               .roles()
               .stream()
               .map(RoleDTO::toDTO)
               .toList();
  }
}
