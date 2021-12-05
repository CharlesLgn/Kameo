package fr.metz.iut.film.dao;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.film.structure.Director;

import java.util.List;

/**
 * DAO of {@link Director}
 */
@AccessForObject(type = Director.class)
class DirectorDAO implements DAO<Director> {

  @Override
  public Director read(final Director director) {
    System.out.println("reading director");
    return null;
  }

  @Override
  public Director read(String id) {
    return null;
  }

  @Override
  public List<Director> readAll() {
    return null;
  }

  @Override
  public Director save(Director director) {
    throw new IllegalAccessError("you can't save a director on IMDB");
  }

  @Override
  public Director update(Director director) {
    throw new IllegalAccessError("you can't update a director on IMDB");
  }

  @Override
  public void delete(String id) {
    throw new IllegalAccessError("you can't delete a director on IMDB");
  }
}
