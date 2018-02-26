package problem7490;

import java.util.ArrayList;
import java.util.List;
import problem7490.n.NTestCase;
import problem7490.util.NumberScanner;

/**
 * @author IntheJ
 * @since 2018-02-14
 */
public class Main7490 {

  private int inputCount;
  private final int MIN_INPUT_COUNT = 1, MAX_INPUT_COUNT = 9;
  private List<NTestCase> nTestCaseList;

  public static void main(final String[] args) {
    new Main7490().run();
  }

  private void run() {
    setInputCount(NumberScanner.scan(MIN_INPUT_COUNT, MAX_INPUT_COUNT));
    initNTestCaseList();
    printNTestCase();
  }

  private void setInputCount(final int inputCount) {
    this.inputCount = inputCount;
  }

  private void initNTestCaseList() {
    nTestCaseList = new ArrayList<>();
    for (int i = 0; i < inputCount; i++) {
      nTestCaseList.add(new NTestCase());
    }
  }

  private void printNTestCase() {
    nTestCaseList.forEach(nTestCase -> {
      nTestCase.printResult();
      System.out.println();
    });
  }
}