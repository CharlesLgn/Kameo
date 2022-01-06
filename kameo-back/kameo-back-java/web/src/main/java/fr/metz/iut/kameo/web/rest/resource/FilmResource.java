package fr.metz.iut.kameo.web.rest.resource;

import fr.metz.iut.crud.Delete;
import fr.metz.iut.crud.Load;
import fr.metz.iut.crud.Save;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.kameo.web.rest.dto.FilmDTO;
import fr.metz.iut.kameo.web.rest.dto.FilmDTOCreate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class FilmResource {

  @GetMapping("/film/{id}")
  public FilmDTO filmById(@PathVariable(value = "id") String id) {
    return FilmDTO.toDTO(Load.get().load(Film.class, id));
  }

  @GetMapping("/film")
  public List<FilmDTO> allFilm() {
    return Load.get().loadAll(Film.class)
               .stream()
               .map(FilmDTO::toDTO)
               .toList();
  }

  @PostMapping("/film")
  public FilmDTO createFilm(@RequestBody FilmDTOCreate film) {
    return FilmDTO.toDTO(Save.get().save(film.toFilm()));
  }

  @PutMapping("/film/{id}")
  public FilmDTO replaceFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTOCreate film) {
    return FilmDTO.toDTO(Save.get().save(film.toFilm()));

  }

  @PatchMapping("/film/{id}")
  public FilmDTO updateFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTOCreate film) {
    return FilmDTO.toDTO(Save.get().save(film.toFilm()));
  }

  @DeleteMapping("/film/{id}")
  public void deleteFilm(@PathVariable(value = "id") String id) {
    Delete.get().delete(Film.class, id);
  }
}
