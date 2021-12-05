package fr.metz.iut.film.dao;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.film.structure.Actor;

import java.util.List;

/**
 * DAO of {@link Actor}
 */
@AccessForObject(type = Actor.class)
class ActorDAO implements DAO<Actor> {

  @Override
  public Actor read(final Actor actor) {
    System.out.println("reading actor");
    return null;
  }

  @Override
  public Actor read(String id) {
    return null;
  }

  @Override
  public List<Actor> readAll() {
    return null;
  }

  @Override
  public Actor save(Actor actor) {
    throw new IllegalAccessError("you can't save an actor on IMDB");
  }

  @Override
  public Actor update(Actor actor) {
    throw new IllegalAccessError("you can't save an actor on IMDB");
  }

  @Override
  public void delete(String id) {
    throw new IllegalAccessError("you can't save an actor on IMDB");
  }
}
