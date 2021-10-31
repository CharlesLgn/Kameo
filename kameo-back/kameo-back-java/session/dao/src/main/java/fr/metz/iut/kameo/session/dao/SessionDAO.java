package fr.metz.iut.kameo.session.dao;

import java.util.List;

import fr.metz.iut.dataacces.*;
import fr.metz.iut.session.structure.Session;

/**
 * DAO of {@link fr.metz.iut.session.structure.Session}
 */
@AccessForObject(type = Session.class)
public class SessionDAO implements DAO<Session> {

  @Override
  public Session read(final Session session) {
    System.out.println("reading session");
    return null;
  }

  @Override
  public Session read(String id) {
    return null;
  }

  @Override
  public List<Session> readAll() {
    return null;
  }

  @Override
  public Session save(Session session) {
    return null;
  }

  @Override
  public Session update(Session session) {
    return null;
  }

  @Override
  public void delete(String id) {

  }
}
