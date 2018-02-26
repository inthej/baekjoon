package problem7490.n;

import java.util.ArrayList;
import java.util.List;
import problem7490.regex.RegEx;
import problem7490.regex.RegExCode;

/**
 * @author IntheJ
 * @since 2018-02-15
 */
class NJoiner {

  private static final StringBuilder nBuilder = new StringBuilder();

  private NJoiner() {
    throw new AssertionError();
  }

  static List<String> newJoinList(final NArray nArray, final List<RegExCode> regExCodeList) {
    final List<String> joinList = new ArrayList<>();
    for (final RegExCode regExCode : regExCodeList) {
      appendJoinCode(nArray, regExCode);
      joinList.add(getJoinedCodeWithRemoveBlank());
      nBuilder.setLength(0);
    }

    return joinList;
  }

  private static void appendJoinCode(final NArray nArray, final RegExCode regExCode) {
    for (int i = 0, length = nArray.length(); i < length; i++) {
      final int num = nArray.numberAt(i);
      if (i < length - 1) {
        nBuilder.append(num)
                .append(regExCode.regExAt(i));
      } else {
        nBuilder.append(num);
      }
    }
  }

  private static String getJoinedCodeWithRemoveBlank() {
    return nBuilder.toString()
                   .replaceAll(String.valueOf(RegEx.BLANK),"");
  }
}
