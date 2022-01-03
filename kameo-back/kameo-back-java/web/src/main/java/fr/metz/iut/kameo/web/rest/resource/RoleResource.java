package fr.metz.iut.kameo.web.rest.resource;

import java.util.Collection;
import java.util.List;

import fr.metz.iut.kameo.web.rest.dto.RoleDTO;
import org.springframework.web.bind.annotation.*;

import fr.metz.iut.film.structure.*;
import fr.metz.iut.kameo.web.falsedata.DataGame;
import fr.metz.iut.kameo.web.rest.dto.FilmDTO;

@RestController
public class RoleResource {

  @GetMapping("/film/{id}/cast")
  public List<RoleDTO> castByFilm(@PathVariable(value = "id") String id) {
    return DataGame.getFilms().stream()
                   .filter(film -> id.equals(film.id()))
                   .map(Film::cast)
                   .flatMap(Collection::stream)
                   .map(RoleDTO::toDTO)
                   .toList();
  }

  @GetMapping("/actor/{id}/cast")
  public List<RoleDTO> castByActor(@PathVariable(value = "id") String id) {
    return DataGame.getPeople().stream()
                   .filter(Actor.class::isInstance)
                   .map(Actor.class::cast)
                   .filter(actor -> id.equals(actor.id()))
                   .map(Actor::roles)
                   .flatMap(Collection::stream)
                   .map(RoleDTO::toDTO)
                   .toList();
  }
}
