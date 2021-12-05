package fr.metz.iut.crud;

import fr.metz.iut.dataacces.PersistentStorage;

import static fr.metz.iut.crud.MapDAO.DAO_CACHE;

final class StandardDelete implements Delete {

  @Override
  public <T extends PersistentStorage> void delete(T t) {
    DAO_CACHE.get(t.getClass()).delete(t.getId());
  }

  enum DeleteSingleton {
    INSTANCE(new StandardDelete());

    final Delete delete;

    DeleteSingleton(final Delete delete) {
      this.delete = delete;
    }
  }
}
