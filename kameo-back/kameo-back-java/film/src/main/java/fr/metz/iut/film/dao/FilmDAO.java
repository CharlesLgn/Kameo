package fr.metz.iut.film.dao;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.film.structure.Film;

import java.util.List;

/**
 * dao of {@link Film}.
 */
@AccessForObject(type = Film.class)
class FilmDAO implements DAO<Film> {

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
