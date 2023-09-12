package com.inditex.rrhh.icmclcwb.model.app.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeUtils {

  private TimeUtils() {
  }

  public static ZonedDateTime ofZonedDateTime(LocalTime time, ZoneId zone) {
    return ZonedDateTime.of(TimeUtils.nowLocalDate(zone), time, zone);
  }

  public static ZonedDateTime ofZonedDateTime(LocalTime time) {
    return ZonedDateTime.of(TimeUtils.nowLocalDate(ZoneId.systemDefault()), time, ZoneId.systemDefault());
  }

  public static ZonedDateTime nowZonedDateTime(ZoneId zone) {
    return ZonedDateTime.now(zone);
  }

  public static ZonedDateTime nowZonedDateTime() {
    return TimeUtils.nowZonedDateTime(ZoneId.systemDefault());
  }

  public static LocalDate nowLocalDate(ZoneId zone) {
    return ZonedDateTime.now(zone).toLocalDate();
  }

  public static LocalDate nowLocalDate() {
    return TimeUtils.nowLocalDate(ZoneId.systemDefault());
  }

  public static LocalDateTime toLocalDateTime(LocalDate localDate) {
    return LocalDateTime.of(localDate, LocalTime.MIDNIGHT);
  }

  public static LocalDateTime nowLocalDateTime(ZoneId zone) {
    return ZonedDateTime.now(zone).toLocalDateTime();
  }

  public static LocalDateTime nowLocalDateTime() {
    return TimeUtils.nowLocalDateTime(ZoneId.systemDefault());
  }

  public static Date nowDate(ZoneId zone) {
    return Date.from(ZonedDateTime.now(zone).toInstant());
  }

  public static Date nowDate() {
    return TimeUtils.nowDate(ZoneId.systemDefault());
  }

  public static ZoneId ofZone(String zoneId) {
    return ZoneId.of(zoneId);
  }

  public static ZoneId ofZone() {
    return ZoneId.systemDefault();
  }

  public static String ofZoneId(String zoneId) {
    return TimeUtils.ofZone(zoneId).getId();
  }

  public static String ofZoneId() {
    return ZoneId.systemDefault().getId();
  }

  public static Instant toInstant(LocalDate localDate) {
    return localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
  }

  public static Instant toInstant(LocalDateTime localDateTime) {
    return localDateTime.toInstant(ZoneOffset.UTC);
  }

  public static Date toDate(LocalDateTime localDateTime) {
    return TimeUtils.toDate(TimeUtils.toInstant(localDateTime));
  }

  public static Date toDate(LocalDate localDate) {
    return TimeUtils.toDate(TimeUtils.toInstant(localDate));
  }

  public static Date toDate(Instant instant) {
    return Date.from(instant);
  }

}
