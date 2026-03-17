package uz.asadbek.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class DateUtils {

  private DateUtils() {
  }

  public static LocalDateTime now() {
    return LocalDateTime.now();
  }

  public static boolean isBetween(LocalDateTime value,
      LocalDateTime from,
      LocalDateTime to) {

    if (value == null) return false;

    if (from != null && value.isBefore(from)) return false;
    if (to != null && value.isAfter(to)) return false;

    return true;
  }

  public static LocalDateTime startOfDay(LocalDate date) {
    if (date == null) return null;
    return date.atStartOfDay();
  }

  public static LocalDateTime endOfDay(LocalDate date) {
    if (date == null) return null;
    return date.atTime(LocalTime.MAX);
  }

  public static LocalDateTime startOfMonth(LocalDate date) {
    if (date == null) return null;
    return date.withDayOfMonth(1).atStartOfDay();
  }

  public static LocalDateTime endOfMonth(LocalDate date) {
    if (date == null) return null;
    return date.withDayOfMonth(date.lengthOfMonth()).atTime(LocalTime.MAX);
  }

  public static boolean isBefore(LocalDateTime a, LocalDateTime b) {
    if (a == null || b == null) return false;
    return a.isBefore(b);
  }

  public static boolean isAfter(LocalDateTime a, LocalDateTime b) {
    if (a == null || b == null) return false;
    return a.isAfter(b);
  }

  public static long daysBetween(LocalDateTime from, LocalDateTime to) {
    if (from == null || to == null) return 0;
    return java.time.Duration.between(from, to).toDays();
  }
}