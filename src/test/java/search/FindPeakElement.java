package search;


/*
  given an array of infected disease find any peak of cases in the array
  // no same duplicate case
  Input: 42, -14, -5, 7, 8, 40, 8, 3
  Output: 40
 */
public class FindPeakElement {
  /** peak element log n solution where pivot is bigger than left && right */
  public int findPeakElement(int[] arr) {
    int n = arr.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((mid == n - 1 || arr[mid] > arr[mid + 1]) && (mid == 0 || arr[mid - 1] < arr[mid]))
        return mid;
      else if (arr[mid] > arr[mid + 1]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FindPeakElement fpe = new FindPeakElement();
    int[] nums = {42, -14, -5, 7, 8, 40, 8, 3};
    System.out.println(nums[fpe.findPeakElement(nums)]);
    nums = new int[]{6,3,2,3,5};
     System.out.println(nums[fpe.findPeakElement(nums)]);
     nums = new int[]{2,6,3,3,3,3,1};
    System.out.println(nums[fpe.findPeakElement(nums)]);
    //System.out.println(fpe.findPeakElement(new int[] {1, 3}));
  }
}
