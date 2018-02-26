package problem7490.n;

/**
 * @author IntheJ
 * @since 2018-02-14
 */
class NArray {

  private final int N;
  static final int SRC_BEGIN = 3, SRC_END = 9;
  private int[] nArray;

  NArray(final int n) {
    N = n;

    initNArray();
  }

  private void initNArray() {
    if (isValidNValue()) {
      nArray = new int[N];
      for (int i = 0; i < N; i++) {
        nArray[i] = i + 1;
      }
    } else {
      throw new InvalidNValueException(N);
    }
  }

  private boolean isValidNValue() {
    return SRC_BEGIN <= N && N <= SRC_END;
  }

  int getN() {
    return N;
  }

  int length() {
    return nArray.length;
  }

  int numberAt(final int index) {
    return nArray[index];
  }

  @Override
  public String toString() {
    final StringBuilder SB = new StringBuilder();
    for (final int num : nArray) {
      SB.append(num);
    }
    return SB.toString();
  }

  private class InvalidNValueException extends RuntimeException {
    private InvalidNValueException(final int value) {
      super("Invalid NValue is " + value + ". srcBegin: " + SRC_BEGIN + ", srcEnd: " + SRC_END);
    }
  }
}
