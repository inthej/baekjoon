package problem7490.n;

import problem7490.util.NumberScanner;

/**
 * @author IntheJ
 * @since 2018-02-14
 */
class NArrayFactory {

  private NArrayFactory() {
    throw new AssertionError();
  }

  public static NArray createNArray() {
    return new NArray(NumberScanner.scan(NArray.SRC_BEGIN, NArray.SRC_END));
  }
}
