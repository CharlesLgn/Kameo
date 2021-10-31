package fr.metz.iut.kameo.film.dao;

import java.util.List;

import fr.metz.iut.dataacces.*;
import fr.metz.iut.film.structure.Film;

/**
 * dao of {@link Film}.
 */
@AccessForObject(type = Film.class)
public class FilmDAO implements DAO<Film> {

  @Override
  public Film read(final Film film) {
    System.out.println("reading film");
    return null;
  }

  @Override
  public Film read(String id) {
    return null;
  }

  @Override
  public List<Film> readAll() {
    return null;
  }

  @Override
  public Film save(Film film) {
    throw new IllegalAccessError("you can't save a film on IMDB");
  }

  @Override
  public Film update(Film film) {
    throw new IllegalAccessError("you can't update a film on IMDB");
  }

  @Override
  public void delete(String id) {
    throw new IllegalAccessError("you can't delete a film on IMDB");
  }
}
