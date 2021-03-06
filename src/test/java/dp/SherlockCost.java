package dp;

/** uses the max cost between B[i] or 1 */
/*

[1 2 3]

[1,1,1], [1,1,2], [1,1,3]
[1,2,1], [1,2,2], [1,2,3]
Our calculations for the arrays are as follows:

|1-1| + |1-1| = 0	|1-1| + |2-1| = 1	|1-1| + |3-1| = 2
|2-1| + |1-2| = 2	|2-1| + |2-2| = 1	|2-1| + |3-2| = 2
The maximum value obtained is .2

 */
public class SherlockCost {
  static int cost(int[] B) {
    int n = B.length;
    int[][] memo = new int[n][2];
    // 0 is 1
    // 1 is max possible
    for (int i = 1; i < n; i++) {
      memo[i][1] =
          Math.max(
              memo[i - 1][0] + Math.abs(1 - B[i]),
              memo[i - 1][1] + Math.abs(B[i - 1] - B[i])); // you took the max
      memo[i][0] = memo[i - 1][1] + Math.abs(B[i - 1] - 1); // you took the min
    }
    return Math.max(memo[n - 1][0], memo[n - 1][1]);
  }

  public static void main(String[] args) {
    System.out.println(cost(new int[] {100, 2, 100, 2, 100}));
  }
}
