package math;

/*
   find element where count > n/2

   using boyer moore voting,

   its election day, find the candidate in voting array that is greater than half of total voting
   its assume theres always a candidate

   3, 4, 1, 4, 4, answer is 4

   forces at least 2 digit together if you dont start at beginning
*/
public class MajorityElement {

  int majorityElement(int[] arr) {

    int count = 1;
    int cand = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (count == 0) {
        count = 1;
        cand = arr[i]; // candidates takes it
      } else if (cand == arr[i]) {
        count++;
      } else {
        count--;
      }
    }
    return cand;
  }

  public static void main(String[] args) {
    System.out.println(new MajorityElement().majorityElement(new int[] {3, 4, 1, 4, 4}));
    System.out.println(new MajorityElement().majorityElement(new int[] {3, 4, 4, 1, 1}));
  }
}
