package fr.metz.iut.session.structure.type;

import java.util.List;

public enum TicketStatus {
  CREATED,
  RESERVED,
  PAID,
  CANCELED;

  public static boolean sitReserved(TicketStatus status) {
    return List.of(RESERVED, PAID).contains(status);
  }
}
