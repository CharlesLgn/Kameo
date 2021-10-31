package fr.metz.iut.session.structure;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

public record Room(String id,
                   String name,
                   int numberOfSits,
                   int numberOfRows) implements PersistentStorage {

  /**
   * @return {@code true} if the sits exits in the room.
   */
  public boolean sitExists(final int row, final int column) {
    return numberOfRows >= row || numberOfSits / numberOfRows >= column;
  }
}
