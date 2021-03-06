package stack;

import java.util.Stack;

/*
  check if a given string has balance parenthesis.
  input can be '{','[','(',')',']','}'


    Input: "([)]"
    Output: NO

    Input: "{[]}"
    Output: YES
 */
public class BalancedParenthesis {

  String isBalanced(String s) {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '{' || c == '[' || c == '(') stack.push(c);
        else if (stack.isEmpty()) return "NO";
        else {
          char p = stack.pop();
          if (c == ')' && p != '(' || c == ']' && p != '[' || c == '}' && p != '{') return "NO";
        }
      }
      return stack.isEmpty() ? "YES" : "NO";
  }


  /*
    : can be either (, ) or empty
   */
  boolean isBalanced2(String s, int b) {

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ':') {
        final String substring = s.substring(i + 1, s.length());
        return isBalanced2('(' + substring, b)
            || isBalanced2(')' + substring, b) ||
            isBalanced2(substring, b);
      } else if (s.charAt(i) == '(') b++;
      else if(b > 0) b--;
      else return false;
    }
    return b == 0;
  }

  public static void main(String[] args) {
    BalancedParenthesis bp = new BalancedParenthesis();
    System.out.println(bp.isBalanced("{[]}"));
    System.out.println(bp.isBalanced("{[()[()]]([])}"));
    System.out.println(bp.isBalanced2("()",0));
    System.out.println(bp.isBalanced2("(:)",0));
    System.out.println(bp.isBalanced2("(:))",0));
  }
}
