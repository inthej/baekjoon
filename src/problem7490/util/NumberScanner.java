package problem7490.util;

import java.util.Scanner;

/**
 * @author IntheJ
 * @since 2018-02-14
 */
public class NumberScanner {

  private static final Scanner scanner = new Scanner(System.in);
  private static int srcBegin, srcEnd;;

  private NumberScanner() {
    throw new AssertionError();
  }

  public static int scan(final int srcBegin, final int srcEnd) {
    setSrcBegin(srcBegin);
    setSrcEnd(srcEnd);

    final int input = scanner.nextInt();
    if (isInvalidRange(input)) {
      throw new InvalidRangeValueException(input);
    }

    return input;
  }

  private static void setSrcBegin(final int srcBegin) {
    NumberScanner.srcBegin = srcBegin;
  }

  private static void setSrcEnd(final int srcEnd) {
    NumberScanner.srcEnd = srcEnd;
  }

  private static boolean isInvalidRange(final int num) {
    return srcBegin >= srcEnd || (num < srcBegin || srcEnd < num);
  }

  private static class InvalidRangeValueException extends RuntimeException {
    private InvalidRangeValueException(final int value) {
      super("Invalid Range Value is" + value + ". srcBegin: " + srcBegin + ", srcEnd: " + srcEnd);
    }
  }
}
