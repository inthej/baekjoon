package problem7490.n;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import problem7490.regex.RegEx;
import problem7490.regex.RegExCode;
import problem7490.regex.RegExCodeFactory;

/**
 * @author IntheJ
 * @since 2018-02-15
 */
public class NTestCase {

  private final int FORMULA_RESULT = 0;
  private int squareValue;

  private final NArray nArray = NArrayFactory.createNArray();
  private final List<RegExCode> regExCodeList = new ArrayList<>();
  private final NStringCalculator nStringCalculator = new NStringCalculator();

  public NTestCase() {
    initSquareVlaue();
    addAllRegExCodeAtList();
  }

  private void initSquareVlaue() {
    squareValue = (int) Math.pow(RegEx.values().length, nArray.getN() - 1);
  }

  private void addAllRegExCodeAtList() {
    for (int i = 0; i < squareValue; i++) {
      regExCodeList.add(RegExCodeFactory.createRegExCode(nArray.getN()));
    }
  }

  public void printResult() {
    final List<String> result = NJoiner.newJoinList(nArray, regExCodeList);
    result.forEach(nString -> {
      if (nStringCalculator.isFormulaResult(nString)) {
        System.out.println(new DoubleNumberCheckAddBlanker(nString).toStringOfCheckedValue());
      }
    });
  }

  private class NStringCalculator {
    private final ScriptEngineManager mgr = new ScriptEngineManager();
    private final String ENGINE_NAME = "JavaScript";
    private final ScriptEngine engine = mgr.getEngineByName(ENGINE_NAME);

    private NStringCalculator() {}

    private boolean isFormulaResult(final String nString) {
      try {
        return (int) engine.eval(nString) == FORMULA_RESULT;
      } catch (final ScriptException e) {
        throw new InvalidNStringException(nString);
      }
    }

    private class InvalidNStringException extends RuntimeException {
      private InvalidNStringException(final String nString) {
        super("Invalid NString is " + nString + ".");
      }
    }
  }

  private class DoubleNumberCheckAddBlanker {
    private final Queue<Character> nQue = new LinkedList<>();
    private char prevChar;

    private DoubleNumberCheckAddBlanker(final String nString) {
      queDataSet(nString);
    }

    private void queDataSet(final String nString) {
      for (final char ch : nString.toCharArray()) {
          nQue.add(ch);
      }
    }

    private String toStringOfCheckedValue() {
      final StringBuilder SB = new StringBuilder();
      while (!nQue.isEmpty()) {
        final char tmpChar = nQue.poll();
        if (isNumChar(prevChar) && isNumChar(tmpChar)) {
          SB.append(RegEx.BLANK);
        }
        SB.append(tmpChar);

        setPrevChar(tmpChar);
      }

      return SB.toString();
    }

    private boolean isNumChar(final char ch) {
      return '0' <= ch && ch <= '9';
    }

    private void setPrevChar(final char ch) {
      this.prevChar = ch;
    }
  }
}
