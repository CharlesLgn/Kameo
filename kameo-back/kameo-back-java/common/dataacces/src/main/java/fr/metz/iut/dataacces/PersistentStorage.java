package fr.metz.iut.dataacces;

/**
 * Represent an object that is stored in a Database (posgres/oracle/xml/ldap...)
 */
public interface PersistentStorage {
  String getId();
}
