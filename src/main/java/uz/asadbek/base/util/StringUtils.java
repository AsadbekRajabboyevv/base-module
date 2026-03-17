package uz.asadbek.base.util;

import java.util.Collection;
import java.util.Objects;

public final class StringUtils {

  private StringUtils() {
  }

  public static boolean isEmpty(String str) {
    return str == null || str.isEmpty();
  }

  public static boolean isBlank(String str) {
    return str == null || str.trim().isEmpty();
  }

  public static boolean hasText(String str) {
    return str != null && !str.trim().isEmpty();
  }

  public static String defaultIfNull(String str, String defaultValue) {
    return str == null ? defaultValue : str;
  }

  public static String defaultIfBlank(String str, String defaultValue) {
    return isBlank(str) ? defaultValue : str;
  }

  public static String trim(String str) {
    return str == null ? null : str.trim();
  }

  public static String lower(String str) {
    return str == null ? null : str.toLowerCase();
  }

  public static String upper(String str) {
    return str == null ? null : str.toUpperCase();
  }

  public static boolean equals(String s1, String s2) {
    return Objects.equals(s1, s2);
  }

  public static boolean containsIgnoreCase(String source, String search) {
    if (isBlank(source) || isBlank(search)) return false;
    return source.toLowerCase().contains(search.toLowerCase());
  }

  public static String join(Collection<?> collection, String delimiter) {
    if (collection == null || collection.isEmpty()) return "";
    return collection.stream()
        .map(Object::toString)
        .reduce((a, b) -> a + delimiter + b)
        .orElse("");
  }
}