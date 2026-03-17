package uz.asadbek.base.util;

import java.lang.Character.UnicodeBlock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

public class ValidationUtils {

  public static boolean isValidPhoneNumber(String phoneNumber) {
    if (!StringUtils.hasText(phoneNumber)) {
      return false;
    } else {
      Pattern pattern = Pattern.compile("^998\\d{9}$");
      Matcher matcher = pattern.matcher(phoneNumber);
      return matcher.matches();
    }
  }
  public static boolean validatePassword(String password) {
    if (StringUtils.hasText(password) && password.length() >= 8 && password.length() <= 20) {
      if (checkContinuous(password)) {
        return true;
      } else {
        return checkCyrilic(password) || checkContainDigitString(password);
      }
    } else {
      return true;
    }
  }

  public static boolean checkCyrilic(String text) {
    int count = 0;

    for(int i = 0; i < text.length(); ++i) {
      if (UnicodeBlock.of(text.charAt(i)).equals(UnicodeBlock.CYRILLIC)) {
        ++count;
      }
    }

    return count > 0;
  }

  private static boolean checkContinuous(String given) {
    byte digitSum = 0;
    byte charSum = 0;
    short digit = 0;
    short letter = 0;

    for(int i = 0; i < given.length(); ++i) {
      short code = (short)given.codePointAt(i);
      if (Character.isDigit(given.charAt(i))) {
        if (code - digit == 1) {
          ++digitSum;
        } else if (digitSum < 2) {
          digitSum = 0;
        }

        digit = code;
      }

      if (Character.isLetter(given.charAt(i))) {
        if (code - letter == 1) {
          ++charSum;
        } else if (charSum < 2) {
          charSum = 0;
        }

        letter = code;
      }
    }

    return digitSum > 2 && charSum > 2;
  }

  private static boolean checkContainDigitString(String given) {
    if (StringUtils.hasText(given)) {
      return false;
    } else {
      int countDigit = 0;
      int countString = 0;

      for(int i = 0; i < given.length(); ++i) {
        if (Character.isSpaceChar(given.charAt(i))) {
          return false;
        }

        if (Character.isDigit(given.charAt(i))) {
          ++countDigit;
        }

        if (Character.isLetter(given.charAt(i))) {
          ++countString;
        }
      }

      return countDigit > 0 && countString > 0;
    }
  }
}