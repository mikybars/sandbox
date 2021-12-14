package com.inditex.rrhh.icmclcwb.model.app.util;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TimeUtilsTest {

  @Test
  void ofZonedDateTimeTest() {
    final ZonedDateTime result = TimeUtils.ofZonedDateTime(LocalTime.of(13, 0));

    assertNotNull(result);
  }

  @Test
  void nowZonedDateTimeTest() {
    final ZonedDateTime result = TimeUtils.nowZonedDateTime();

    assertNotNull(result);
  }

  @Test
  void ofZoneIdTest() {
    final String result = TimeUtils.ofZoneId("Europe/Madrid");

    assertNotNull(result);
  }

  @Test
  void toDateTest() {
    final Date result = TimeUtils.toDate(LocalDateTime.of(2021, 12, 07, 00, 00));

    assertNotNull(result);
  }

  @Test
  void nowLocalDateTest() {
    final LocalDate result = TimeUtils.nowLocalDate();

    assertNotNull(result);
  }

  @Test
  void toLocalDateTimeTest() {
    final LocalDateTime result = TimeUtils.toLocalDateTime(LocalDate.now());

    assertNotNull(result);
  }

}
