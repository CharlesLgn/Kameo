package fr.metz.iut.kameo.common.dataacces.crud;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.kameo.common.dataacces.crud.StandardLoad.LoadSingleton;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Delete an object using the DAO of the object
 */
public interface Delete {

  static Delete get() {
    return StandardDelete.DeleteSingleton.INSTANCE.delete;
  }

  <T extends PersistentStorage> void delete(T t);

  default <T extends PersistentStorage> void delete(T... ts) {
    Stream.of(ts).forEach(this::delete);
  }

  default <T extends PersistentStorage> void delete(Collection<T> ts) {
    ts.forEach(this::delete);
  }
}
