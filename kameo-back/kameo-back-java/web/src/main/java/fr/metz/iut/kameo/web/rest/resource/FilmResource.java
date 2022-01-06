package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.crud.Delete;
import fr.metz.iut.crud.Load;
import fr.metz.iut.crud.Save;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.kameo.web.rest.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class FilmResource {

  @GetMapping("/film")
  public List<FilmReferenceDTO> allFilm() {
    return Load.get().loadAll(Film.class)
               .stream()
               .map(FilmReferenceDTO::new)
               .toList();
  }

  @GetMapping("/film/{id}")
  public FilmDTO filmById(@PathVariable(value = "id") String id) {
    return new FilmDTO(Load.get().load(Film.class, id));
  }

  @PostMapping("/film")
  public FilmDTO createFilm(@RequestBody FilmDTOCreate film) {
    return new FilmDTO(Save.get().save(film.toFilm()));
  }

  @PutMapping("/film/{id}")
  public FilmDTO replaceFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTOCreate film) {
    return new FilmDTO(Save.get().save(film.toFilm()));

  }

  @PatchMapping("/film/{id}")
  public FilmDTO updateFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTOCreate film) {
    return new FilmDTO(Save.get().save(film.toFilm()));
  }

  @DeleteMapping("/film/{id}")
  public void deleteFilm(@PathVariable(value = "id") String id) {
    Delete.get().delete(Film.class, id);
  }

  @GetMapping("/film/{id}/cast")
  public List<CastDTO> castByFilm(@PathVariable(value = "id") String id) {
    return Optional.ofNullable(Load.get().load(Film.class, id))
                   .stream()
                   .map(Film::cast)
                   .flatMap(Collection::stream)
                   .map(CastDTO::new)
                   .toList();
  }
}
