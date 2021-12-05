package fr.metz.iut.crud;

import fr.metz.iut.dataacces.AccessForObject;
import fr.metz.iut.dataacces.DAO;
import fr.metz.iut.dataacces.PersistentStorage;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

final class MapDAO {

  private MapDAO() {
    throw new IllegalAccessError("non instantiable");
  }

  static final Map<Class<? extends PersistentStorage>, DAO<? extends PersistentStorage>> DAO_CACHE = new HashMap<>();

  static {
    initMap();
  }

  private static void initMap() {
    new Reflections("fr.metz.iut").getSubTypesOf(DAO.class)
                                        .stream()
                                        .filter(dao -> dao.isAnnotationPresent(AccessForObject.class))
                                        .forEach(MapDAO::addDaoInCache);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private static void addDaoInCache(final Class<? extends DAO> dao) {
    try {
      DAO_CACHE.put(dao.getAnnotation(AccessForObject.class).type(), dao.getConstructor().newInstance());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
