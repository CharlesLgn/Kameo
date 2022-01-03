package fr.metz.iut.crud;

import fr.metz.iut.dataacces.PersistentStorage;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Delete an object using the DAO of the object
 */
public interface Delete {

  static Delete get() {
    return StandardDelete.DeleteSingleton.INSTANCE.delete;
  }

  <T extends PersistentStorage> void delete(T t);

  <T extends PersistentStorage> void delete(Class<T> t, String id);

  default <T extends PersistentStorage> void delete(T... ts) {
    Stream.of(ts).forEach(this::delete);
  }

  default <T extends PersistentStorage> void delete(Collection<T> ts) {
    ts.forEach(this::delete);
  }
}
