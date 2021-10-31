package fr.metz.iut.common.utils.date;

import java.time.*;
import java.util.Date;

public final class DateUtils {

  private DateUtils() {}

  public static Date getDate(int year, int month, int day) {
    return Date.from(LocalDate.of(year, month, day)
                              .atStartOfDay()
                              .atZone(ZoneId.systemDefault())
                              .toInstant());
  }
}
