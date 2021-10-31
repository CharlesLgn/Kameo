package fr.metz.iut.session.structure;

import java.util.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;
import fr.metz.iut.film.structure.Film;
import fr.metz.iut.session.exception.SitNotAvailableException;
import fr.metz.iut.session.structure.type.TicketStatus;

/**
 * A session represent when and where a {@link Film} is displayed.
 */
public class Session implements PersistentStorage {

  private final String id;
  private final Date sessionDate;
  private final Room room;
  private final Film film;
  private final Set<Ticket> tickets = new HashSet<>();

  public Session(final String id, final Date sessionDate, final Room room, final Film film) {
    this.id = id;
    this.sessionDate = sessionDate;
    this.room = room;
    this.film = film;
  }

  public String id() {
    return id;
  }

  public Date sessionDate() {
    return sessionDate;
  }

  public Room room() {
    return room;
  }

  public Film film() {
    return film;
  }

  public Set<Ticket> tickets() {
    return Collections.unmodifiableSet(tickets);
  }

  public void addTicket(final Ticket ticket) {
    removeTicket(ticket);
    tickets.add(ticket);
  }

  public void removeTicket(final Ticket ticket) {
    tickets.removeIf(t -> t.id().equals(ticket.id()));
  }

  public void reservedPlace(final Ticket ticket) throws SitNotAvailableException {
    if (!isSitPossible(ticket.row(), ticket.column())) {
      throw new SitNotAvailableException();
    }
    addTicket(ticket);
  }

  private boolean isSitPossible(final int row, final int column) {
    return room.sitExists(row, column)
           && sitNotTaken(row, column);
  }

  private boolean sitNotTaken(final int row, final int column) {
    return tickets.stream()
                  .filter(ticket -> TicketStatus.sitReserved(ticket.status()))
                  .anyMatch(ticket -> ticket.row() == row && ticket.column() == column);
  }
}
