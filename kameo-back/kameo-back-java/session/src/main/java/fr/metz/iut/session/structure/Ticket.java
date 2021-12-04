package fr.metz.iut.session.structure;

import static fr.metz.iut.session.structure.type.TicketStatus.*;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.session.exception.SitNotAvailableException;
import fr.metz.iut.session.structure.type.TicketStatus;

public final class Ticket implements PersistentStorage {

  private final String id;
  private final double price;
  private final Session session;
  private final TicketStatus status;
  private final int row;
  private final int column;

  public Ticket(String id, double price, Session session, TicketStatus status, int row, int column) {
    this.id = id;
    this.price = price;
    this.session = session;
    this.status = status;
    this.row = row;
    this.column = column;
  }

  public Ticket(Session session) {
    this(UUID.randomUUID().toString(), 9.50, session, CREATED, -1, -1);
  }

  public Ticket chooseSit(int row, int column) throws SitNotAvailableException {
    var ticket = new Ticket(id, price, session, RESERVED, row, column);
    session.reservedPlace(ticket);
    return ticket;
  }

  public Ticket paid() {
    return new Ticket(id, price, session, PAID, row, column);
  }

  public Ticket cancel() {
    return new Ticket(id, price, session, CANCELED, row, column);
  }

  @Override
  public String getId() {
    return id;
  }

  public double getPrice() {
    return price;
  }

  public Session getSession() {
    return session;
  }

  public TicketStatus getStatus() {
    return status;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }
}
