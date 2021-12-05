package fr.metz.iut.crud;

import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.dataacces.PersistentStorage;

import java.util.List;

import static fr.metz.iut.crud.MapDAO.DAO_CACHE;

final class StandardLoad implements Load {

  @Override
  @SuppressWarnings("unchecked")
  public <T extends PersistentStorage> T load(final T t) {
    return ((DAO<T>) DAO_CACHE.get(t.getClass())).read(t);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends PersistentStorage> T load(Class<T> clazz, String id) {
    return ((DAO<T>) DAO_CACHE.get(clazz)).read(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends PersistentStorage> List<T> loadAll(Class<T> tClass) {
    return ((DAO<T>) DAO_CACHE.get(tClass)).readAll();
  }

  enum LoadSingleton {
    INSTANCE(new StandardLoad());

    final Load load;

    LoadSingleton(final Load load) {
      this.load = load;
    }
  }
}
