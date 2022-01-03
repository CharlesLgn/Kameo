package fr.metz.iut.kameo.web.rest.resource;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import fr.metz.iut.film.structure.*;
import fr.metz.iut.kameo.web.falsedata.DataGame;
import fr.metz.iut.kameo.web.rest.dto.FilmDTO;

@RestController
public class DirectorResource {

  @GetMapping("/film/{id}")
  public FilmDTO filmById(@PathVariable(value = "id") String id) {
    return allFilm().stream()
                    .filter(filmDTO -> id.equals(filmDTO.id()))
                    .findFirst()
                    .orElse(null);
  }

  @GetMapping("/film")
  public List<FilmDTO> allFilm() {
    return DataGame.getFilms().stream().map(FilmDTO::toDTO).toList();
  }

  @PostMapping("/film")
  public FilmDTO createFilm(@RequestBody FilmDTO film) {
    return addFilm(DataGame.generateNewId(), film);
  }

  @PutMapping("/film/{id")
  public FilmDTO replaceFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTO film) {
    deleteFilm(id);
    return addFilm(id, film);
  }

  @PatchMapping("/film/{id")
  public FilmDTO updateFilm(@PathVariable(value = "id") String id, @RequestBody FilmDTO film) {
    deleteFilm(id);
    return addFilm(id, film);
  }

  @DeleteMapping("/film/{id")
  public void deleteFilm(@PathVariable(value = "id") String id) {
    DataGame.getFilms()
            .stream()
            .filter(film -> film.id().equals(id))
            .findFirst()
            .ifPresent(DataGame.getFilms()::remove);
  }

  private FilmDTO addFilm(String id, FilmDTO filmDTO) {
    Director director = DataGame.getPeople()
                                .stream()
                                .filter(Director.class::isInstance)
                                .map(Director.class::cast)
                                .filter(person -> filmDTO.directorId().equals(person.id()))
                                .findFirst()
                                .orElseThrow();
    Film newFilm = new Film(id, filmDTO.name(), filmDTO.releaseDate(), director, filmDTO.summary(), filmDTO.typeOfFilm(), -1);
    DataGame.getFilms().add(newFilm);
    return FilmDTO.toDTO(newFilm);
  }
}
