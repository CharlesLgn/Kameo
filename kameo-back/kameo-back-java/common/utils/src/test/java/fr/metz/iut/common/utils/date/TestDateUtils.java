package fr.metz.iut.common.utils.date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.metz.iut.common.utils.date.DateUtils;

class TestDateUtils {

  @Test
  void test() {
    Assertions.assertThat(DateUtils.getDate(2020, 1, 1))
              .hasToString("Wed Jan 01 00:00:00 CET 2020")
              .hasYear(2020)
              .hasMonth(1)
              .hasDayOfMonth(1)
              .hasHourOfDay(0)
              .hasMinute(0)
              .hasSecond(0)
              .hasMillisecond(0);
  }
}