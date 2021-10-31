package fr.metz.iut.kameo.common.dataacces.crud;

import java.util.*;
import java.util.stream.Stream;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.kameo.common.dataacces.crud.StandardLoad.LoadSingleton;

/**
 * Load an object using the DAO of the object
 */
public interface Load {

  static Load get() {
    return LoadSingleton.INSTANCE.load;
  }

  <T extends PersistentStorage> T load(T t);

  <T extends PersistentStorage> T load(Class<T> clazz, String id);

  default <T extends PersistentStorage> List<T> load(T... ts) {
    return Stream.of(ts).map(this::load).toList();
  }

  default <T extends PersistentStorage> List<T> load(Collection<T> ts) {
    return ts.stream().map(this::load).toList();
  }

  <T extends PersistentStorage> List<T> loadAll(Class<T> tClass);
}
