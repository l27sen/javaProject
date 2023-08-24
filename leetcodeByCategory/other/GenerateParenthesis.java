package leetcodeByCategory.other;

import java.util.ArrayList;
import java.util.List;

/**
 * (()) ()()
 */
public class GenerateParenthesis {


  public static void main(String[] a) {
    List<String> result = generate(2);
    result.forEach(s -> System.out.println(s));
  }

  public static List<String> generate(int n) {

    List<String> result = new ArrayList<>();
    helper(result, "", n, n);
    return result;
  }

  public static void helper(List<String> results, String temp, int left, int right) {

    //in this case, already has too many '}"

    if (left > right) {
      return;
    }

    if (left == 0 && right == 0) {
      results.add(temp);
      return;
    }
    if (left > 0) {
      helper(results, temp + "{", left - 1, right);
    }

    if (right > left) {
      helper(results, temp + "}", left, right - 1);
    }
  }
}
