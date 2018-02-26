package problem7490.regex;

/**
 * @author IntheJ
 * @since 2018-02-15
 */
public class RegExCode {

  private RegEx[] regExes;
  private int n;

  RegExCode(final int n) {
    setN(n);
    initRegExs(n);
  }

  private void setN(final int n) {
    this.n = n;
  }

  private void initRegExs(final int n) {
    regExes = new RegEx[n - 1];
    for (int i = 0, length = length(); i < length; i++) {
      regExes[i] = RegEx.PLUSE;
    }
  }

  int length() {
    return regExes.length;
  }

  public RegEx regExAt(final int index) {
    return regExes[index];
  }

  void setRegEx(final int index, final RegEx regEx) {
    regExes[index] = regEx;
  }

  RegExCode cloneCode() {
    final RegExCode cloneCode = new RegExCode(n);
    for (int i = 0, length = length(); i < length; i++) {
      cloneCode.setRegEx(i, regExes[i]);
    }
    return cloneCode;
  }

  @Override
  public String toString() {
    final StringBuilder SB = new StringBuilder();
    for (final RegEx regEx : regExes) {
      SB.append(regEx);
    }
    return SB.toString();
  }
}
