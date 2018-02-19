package problem2839;

import java.util.Scanner;

/**
 * @author IntheJ
 * @since 2018-02-19
 */
public class Main2839 {

  private static int inputNumber, sugarBagCount;

  private static final int INVALID_COUNT = -1;
  private static final int THREE_KILOGRAM = 3, FIVE_KILOGRAM = 5;

  public static void main(final String[] args) {
    setInputNumber(scanNumber());

    if (isValidNumber()) {
      printSugarBagCount();
    }
  }

  private static int scanNumber() {
    final Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  private static void setInputNumber(final int count) {
    inputNumber = count;
  }

  private static boolean isValidNumber() {
    return 3 <= inputNumber && inputNumber <= 5_000;
  }

  private static void printSugarBagCount() {
    computeBagCount(inputNumber);
    System.out.println(sugarBagCount);
  }

  private static void setSugarBagCount(final int count) {
    sugarBagCount = count;
  }

  private static void computeBagCount(final int kilogram) {
    setSugarBagCount(factorialCount(kilogram));
  }

  private static int factorialCount(final int kilogram) {
    if (kilogram % FIVE_KILOGRAM == 0) {
      return sugarBagCount += kilogram / FIVE_KILOGRAM;
    }

    if (kilogram < THREE_KILOGRAM) {
      return sugarBagCount = INVALID_COUNT;
    }

    sugarBagCount += 1;

    return factorialCount(kilogram - THREE_KILOGRAM);
  }
}