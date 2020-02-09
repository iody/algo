package bit;

import java.util.ArrayList;

import static java.lang.System.out;

public class GrayCode {
  /*
  The gray code is a binary numeral system where two successive values differ in only one bit.

  Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

  Example 1:

  Input: 2
  Output: [0,1,3,2]
  Explanation:
  00 - 0
  01 - 1
  11 - 3
  10 - 2

  For a given n, a gray code sequence may not be uniquely defined.
  For example, [0,2,3,1] is also a valid gray code sequence.

  00 - 0
  10 - 2
  11 - 3
  01 - 1
   */
  public ArrayList<Integer> grayCode(int n) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(0);
    for (int i = 0; i < n; i++) {
      for (int j = arr.size() - 1, pad = 1 << i; j >= 0; j--) {
        arr.add(pad + arr.get(j));
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    out.println(new GrayCode().grayCode(2));
  }
}
