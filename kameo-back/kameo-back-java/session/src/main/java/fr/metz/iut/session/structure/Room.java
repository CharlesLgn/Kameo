package fr.metz.iut.session.structure;

import java.util.Objects;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

public final class Room implements PersistentStorage {

  private final String id;
  private final String name;
  private final int numberOfSits;
  private final int numberOfRows;

  public Room(String id, String name, int numberOfSits, int numberOfRows) {
    this.id = id;
    this.name = name;
    this.numberOfSits = numberOfSits;
    this.numberOfRows = numberOfRows;
  }

  @Override
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getNumberOfSits() {
    return numberOfSits;
  }

  public int getNumberOfRows() {
    return numberOfRows;
  }

  /**
   * @return {@code true} if the sits exits in the room.
   */
  public boolean sitExists(final int row, final int column) {
    return numberOfRows >= row || numberOfSits / numberOfRows >= column;
  }
}
