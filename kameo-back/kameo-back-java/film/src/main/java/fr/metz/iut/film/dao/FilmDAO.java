package fr.metz.iut.film.dao;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.film.dao.falseData.DataGame;
import fr.metz.iut.film.structure.Film;

import java.util.List;

/**
 * dao of {@link Film}.
 */
@AccessForObject(type = Film.class)
public class FilmDAO implements DAO<Film> {

  @Override
  public Film read(final Film film) {
    return read(film.id());
  }

  @Override
  public Film read(String id) {
    return DataGame.getFilms().stream()
                   .filter(filmDTO -> id.equals(filmDTO.id()))
                   .findFirst()
                   .orElse(null);
  }

  @Override
  public List<Film> readAll() {
    return DataGame.getFilms();
  }

  @Override
  public Film save(Film film) {
    DataGame.getFilms().add(film);
    return film;
  }

  @Override
  public Film update(Film film) {
    delete(film.id());
    return save(film);
  }

  @Override
  public void delete(String id) {
    DataGame.getFilms().stream()
            .filter(filmDTO -> id.equals(filmDTO.id()))
            .findFirst()
            .ifPresent(DataGame.getFilms()::remove);
  }
}
