package fr.metz.iut.dataacces;

import java.util.List;

/**
 * Represent all common method to access and modify a {@link PersistentStorage persistent data}.
 */
public interface DAO<T extends PersistentStorage> {

  /** @return the {@link T} object loaded. */
  T read(T t);

  /** @return the {@link T} object loaded throught the ID. */
  T read(String id);


  /** @return all {@link T} object loaded. */
  List<T> readAll();

  /** @return {@link T} object saved. */
  T save(T t);

  /** @return {@link T} object updated. */
  T update(T t);

  /** delete the {@link T} just using the ID. */
  void delete(String id);
}
