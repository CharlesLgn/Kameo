package fr.metz.iut.crud;

import fr.metz.iut.dataacces.PersistentStorage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Load an object using the DAO of the object
 */
public interface Load {

  static Load get() {
    return StandardLoad.LoadSingleton.INSTANCE.load;
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
