package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanInteger {
  public String intToRoman(int num) {
    LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
    hm.put(1000, "M");
    hm.put(900, "CM");
    hm.put(500, "D");
    hm.put(400, "CD");
    hm.put(100, "C");
    hm.put(90, "XC");
    hm.put(50, "L");
    hm.put(40, "XL");
    hm.put(10, "X");
    hm.put(9, "IX");
    hm.put(5, "V");
    hm.put(4, "IV");
    hm.put(1, "I");

    StringBuilder sb = new StringBuilder();

    for (Map.Entry<Integer, String> e : hm.entrySet()) {
      // System.out.println(e.getKey());
      while (num >= e.getKey()) { // if statement can be converted to while statement
        sb.append(e.getValue());
        num -= e.getKey();
      }
    }
    return sb.toString();
  }

  public static void main(String args[]) {
    RomanInteger rm = new RomanInteger();
    // 1 - 3999
    System.out.println(rm.intToRoman(3999));
  }
}
