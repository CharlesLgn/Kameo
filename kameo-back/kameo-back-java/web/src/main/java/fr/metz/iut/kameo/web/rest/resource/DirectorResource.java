package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.kameo.web.falsedata.DataGame;
import fr.metz.iut.kameo.web.rest.dto.FilmDTO;
import fr.metz.iut.kameo.web.rest.dto.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class DirectorResource {

  @GetMapping("/director/{id}")
  public PersonDTO directorById(@PathVariable(value = "id") String id) {
    return DataGame.getPeople().stream()
                   .filter(Director.class::isInstance)
                   .filter(person -> id.equals(person.id()))
                   .map(PersonDTO::toDTO)
                   .findFirst()
                   .orElse(null);
  }

  @GetMapping("/director/{id}/films")
  public List<FilmDTO> filmByDirector(@PathVariable(value = "id") String id) {
    return DataGame.getPeople().stream()
                   .filter(Director.class::isInstance)
                   .map(Director.class::cast)
                   .filter(person -> id.equals(person.id()))
                   .map(Director::films)
                   .flatMap(Collection::stream)
                   .map(FilmDTO::toDTO)
                   .toList();
  }
}
