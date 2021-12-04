package fr.metz.iut.common.utils.dataaccess;

/**
 * Represent an object that is stored in a Database (posgres/oracle/xml/ldap...)
 */
public interface PersistentStorage {
  String getId();
}
