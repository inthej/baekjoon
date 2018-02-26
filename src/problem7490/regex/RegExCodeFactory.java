package problem7490.regex;

import static problem7490.regex.RegEx.BLANK;
import static problem7490.regex.RegEx.MINUS;
import static problem7490.regex.RegEx.PLUSE;

/**
 * @author IntheJ
 * @since 2018-02-15
 */
public class RegExCodeFactory {

  private static RegExCode currentRegExCode;
  private static int n;

  private RegExCodeFactory() {
    throw new AssertionError();
  }

  public static RegExCode createRegExCode(final int n) {
    setN(n);

    return currentRegExCode = isEmptyCode() || isAllBlank()
                                ? newCode()
                                : factorialNextCode(currentRegExCode.length() - 1);
  }

  private static void setN(final int n) {
    RegExCodeFactory.n = n;
  }

  private static boolean isEmptyCode() {
    return currentRegExCode == null;
  }

  private static boolean isAllBlank() {
    boolean result = true;
    for (int i = 0, length = currentRegExCode.length(); i < length; i++) {
      if (BLANK != currentRegExCode.regExAt(i)) {
        result = false;
      }
    }
    return result;
  }

  private static RegExCode newCode() {
    return new RegExCode(n);
  }

  private static RegExCode factorialNextCode(final int index) {
    currentRegExCode = currentRegExCode.cloneCode();

    switch (currentRegExCode.regExAt(index)) {
      case PLUSE:
        currentRegExCode.setRegEx(index, MINUS);
        break;
      case MINUS:
        currentRegExCode.setRegEx(index, BLANK);
        break;
      case BLANK:
        if (0 <= index) {
          currentRegExCode.setRegEx(index, PLUSE);
          factorialNextCode(index - 1);
        } else {
          currentRegExCode = newCode();
        }
        break;
      default:
    }

    return currentRegExCode;
  }
}
