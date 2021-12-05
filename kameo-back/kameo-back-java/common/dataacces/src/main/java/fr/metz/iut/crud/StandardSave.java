package fr.metz.iut.crud;

import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.dataacces.PersistentStorage;

import static fr.metz.iut.crud.MapDAO.DAO_CACHE;

final class StandardSave implements Save {

  @Override
  @SuppressWarnings("unchecked")
  public <T extends PersistentStorage> T save(T t) {
    if (t.getId() != null) {
      return ((DAO<T>) DAO_CACHE.get(t.getClass())).save(t);
    }
    return ((DAO<T>) DAO_CACHE.get(t.getClass())).update(t);
  }

  enum SaveSingleton {
    INSTANCE(new StandardSave());

    final Save save;

    SaveSingleton(final Save save) {
      this.save = save;
    }
  }
}
