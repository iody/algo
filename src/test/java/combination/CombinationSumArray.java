package combination;

import java.util.*;

import static java.lang.System.out;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * <p>The same repeated number may be chosen from candidates unlimited number of times.
 *
 * <p>Input: candidates = [2,3,6,7], target = 7, Output: [ [7], [2,2,3] ]
 */
public class CombinationSumArray {
  void combinationSum(
      int[] candidates,
      int j,
      int target,
      ArrayList<Integer> curr,
      ArrayList<ArrayList<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    }

    if (target < 0) return;
    for (int i = j; i < candidates.length; i++) {
      curr.add(candidates[i]); // forward
      combinationSum(candidates, i, target - candidates[i], curr, res);
      curr.remove(curr.size() - 1); // backtrack
    }
  }

  ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    combinationSum(candidates, 0, target, new ArrayList<>(), res);
    return res;
  }

  public static void main(String[] args) {
    //  out.println(new CombinationSumArray().combinationSum(new int[]{7,8,10,6,8},28));
    out.println(new CombinationSumArray().combinationSum(new int[] {2, 3, 6, 7}, 7));
  }
}
