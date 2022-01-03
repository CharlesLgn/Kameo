package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.crud.Load;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.kameo.web.rest.dto.FilmDTO;
import fr.metz.iut.kameo.web.rest.dto.PersonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorResource {

  @GetMapping("/director/{id}")
  public PersonDTO directorById(@PathVariable(value = "id") String id) {
    return PersonDTO.toDTO(Load.get().load(Director.class, id));

  }

  @GetMapping("/director/{id}/films")
  public List<FilmDTO> filmByDirector(@PathVariable(value = "id") String id) {
    return Load.get().load(Director.class, id)
               .films()
               .stream()
               .map(FilmDTO::toDTO)
               .toList();
  }
}
