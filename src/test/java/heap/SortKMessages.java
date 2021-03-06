package heap;

import java.util.PriorityQueue;
import java.util.Arrays;

/** sort elements using PriorityQueue nlogk, works well if k is a small number */
public class SortKMessages {
  // offset insertion by inserting 1st in the priority queue
  static int[] sortKMessedArray(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= arr.length + k; i++) {
      if (i < arr.length) pq.offer(arr[i]);
      if (i > k) arr[i - k - 1] = pq.poll();
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(sortKMessedArray(new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));
  }
}
