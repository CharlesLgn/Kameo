package fr.metz.iut.crud;

import fr.metz.iut.dataacces.PersistentStorage;

import static fr.metz.iut.crud.MapDAO.DAO_CACHE;

final class StandardDelete implements Delete {

  @Override
  public <T extends PersistentStorage> void delete(T t) {
    delete(t.getClass(), t.getId());
  }

  @Override
  public <T extends PersistentStorage> void delete(Class<T> t, String id) {
    DAO_CACHE.get(t).delete(id);
  }

  enum DeleteSingleton {
    INSTANCE(new StandardDelete());

    final Delete delete;

    DeleteSingleton(final Delete delete) {
      this.delete = delete;
    }
  }
}
