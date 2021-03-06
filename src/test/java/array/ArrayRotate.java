package array;

import java.util.Arrays;

/**
 * given an array rotate the array to the right k times
 *
 * Input:
 * {1, 2, 3, 4, 5, 6, 7} ,4
 *
 * Output:
 * [4, 5, 6, 7, 1, 2, 3]
 * Created by johnlim on 10/2/16.
 * */
public class ArrayRotate {

  // using in place swwap
  public void rotate(int[] nums, int k) {
    while (--k >= 0) {
      for (int i = nums.length - 1; i > 0; i--) {
        int temp = nums[i - 1];
        nums[i - 1] = nums[i];
        nums[i] = temp; // we shift 1 in place by swap;
      }
    }
  }

  // in place but linear time by immediatly jumping to the target O(n)
  public void rotateInPlace(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }

  // rotate by reversal O(n)
  //  clockwise, means to the right
  public void rotateReverse(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  // rotate with additional array O(n)
  public void rotateNew(int[] A, int K) {
    int[] r = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      r[(i + K) % A.length] = A[i];
    }
    System.out.println(Arrays.toString(r));
  }

  public static void main(String args[]) {

    ArrayRotate t = new ArrayRotate();
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
    t.rotateInPlace(arr, 4);
    System.out.println(Arrays.toString(arr));
    int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7};
    t.rotateNew(arr2, 11);
    int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7};
    t.rotate(arr3, 11);
    System.out.println(Arrays.toString(arr3));
    int[] arr4 = new int[] {1, 2, 3, 4, 5, 6, 7};
    t.rotateReverse(arr4, 11);
    System.out.println(Arrays.toString(arr4));
  }
}
