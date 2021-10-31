package fr.metz.iut.kameo.common.dataacces.crud;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.dataacces.DAO;

import java.util.List;

import static fr.metz.iut.kameo.common.dataacces.crud.MapDAO.DAO_CACHE;

final class StandardSave implements Save {

  @Override
  @SuppressWarnings("unchecked")
  public <T extends PersistentStorage> T save(T t) {
    if (t.id() != null) {
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
