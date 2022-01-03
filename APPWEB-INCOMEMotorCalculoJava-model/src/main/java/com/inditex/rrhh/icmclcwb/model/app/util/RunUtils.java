package com.inditex.rrhh.icmclcwb.model.app.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class RunUtils {

  private RunUtils() {
  }

  public static String addDays(final LocalDateTime ldt, int number, String datePattern) {
    return RunUtils.addDays(ldt, number).format(DateTimeFormatter.ofPattern(datePattern));
  }

  public static String addDays(final LocalDate ldt, int number, String datePattern) {
    return RunUtils.addDays(ldt, number).format(DateTimeFormatter.ofPattern(datePattern));
  }

  public static LocalDateTime addDays(final LocalDateTime ldt, int number) {
    LocalDateTime date = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(),
        ldt.getMinute(), ldt.getSecond());
    return date.plusDays(number);
  }

  public static LocalDate addDays(final LocalDate ldt, int number) {
    LocalDate date = LocalDate.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth());
    return date.plusDays(number);
  }

}
