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
    return read(director.id());
  }

  @Override
  public Director read(String id) {
    return DataGame.getPeople().stream()
                   .filter(Director.class::isInstance)
                   .filter(person -> id.equals(person.id()))
                   .map(Director.class::cast)
                   .findFirst()
                   .orElse(null);
  }

  @Override
  public List<Director> readAll() {
    return DataGame.getPeople().stream()
                   .filter(Director.class::isInstance)
                   .map(Director.class::cast)
                   .toList();
  }

  @Override
  public Director save(Director director) {
    DataGame.getPeople().add(director);
    return director;
  }

  @Override
  public Director update(Director director) {
    delete(director.id());
    return save(director);
  }

  @Override
  public void delete(String id) {
    DataGame.getPeople().stream()
            .filter(Director.class::isInstance)
            .filter(person -> id.equals(person.id()))
            .map(Director.class::cast)
            .findFirst()
            .ifPresent(DataGame.getPeople()::remove);
  }
}
