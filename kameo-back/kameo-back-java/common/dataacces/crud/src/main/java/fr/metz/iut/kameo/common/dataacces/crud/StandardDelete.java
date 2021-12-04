package fr.metz.iut.kameo.common.dataacces.crud;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.dataacces.DAO;

import java.util.List;

import static fr.metz.iut.kameo.common.dataacces.crud.MapDAO.DAO_CACHE;

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
