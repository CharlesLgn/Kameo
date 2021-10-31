package fr.metz.iut.kameo.film.dao;

import java.util.List;

import fr.metz.iut.dataacces.*;
import fr.metz.iut.film.structure.*;

/**
 * DAO of {@link Role}
 */
@AccessForObject(type = Role.class)
public class RoleDAO implements DAO<Role> {

  @Override
  public Role read(final Role role) {
    System.out.println("reading role");
    return null;
  }

  @Override
  public Role read(String id) {
    return null;
  }

  @Override
  public List<Role> readAll() {
    return null;
  }

  @Override
  public Role save(Role role) {
    throw new IllegalAccessError("you can't save a role on IMDB");
  }

  @Override
  public Role update(Role role) {
    throw new IllegalAccessError("you can't update a role on IMDB");
  }

  @Override
  public void delete(String id) {
    throw new IllegalAccessError("you can't delete a role on IMDB");
  }
}
