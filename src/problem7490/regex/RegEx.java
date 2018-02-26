package problem7490.regex;

/**
 * @author IntheJ
 * @since 2018-02-15
 */
public enum RegEx {
  PLUSE('+'),
  MINUS('-'),
  BLANK(' ');

  private final char regEx;

  RegEx(final char regEx) {
    this.regEx = regEx;
  }

  @Override
  public String toString() {
    return String.valueOf(regEx);
  }
}
