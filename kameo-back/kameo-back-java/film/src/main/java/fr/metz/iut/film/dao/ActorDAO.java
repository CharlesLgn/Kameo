package fr.metz.iut.film.dao;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Director;

import java.util.List;

/**
 * DAO of {@link Director}
 */
@AccessForObject(type = Actor.class)
class ActorDAO implements DAO<Actor> {

  @Override
  public Actor read(final Actor actor) {
    return read(actor.id());
  }

  @Override
  public Actor read(String id) {
    return DataGame.getPeople().stream()
                   .filter(Actor.class::isInstance)
                   .filter(person -> id.equals(person.id()))
                   .map(Actor.class::cast)
                   .findFirst()
                   .orElse(null);
  }

  @Override
  public List<Actor> readAll() {
    return DataGame.getPeople().stream()
                   .filter(Actor.class::isInstance)
                   .map(Actor.class::cast)
                   .toList();
  }

  @Override
  public Actor save(Actor actor) {
    DataGame.getPeople().add(actor);
    return actor;
  }

  @Override
  public Actor update(Actor actor) {
    delete(actor.id());
    return save(actor);
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
