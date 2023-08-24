package leetcodeByCategory.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombineArray {

  public static void main(String[] a) {
    List<List<Integer>> result = combinArray(7);
    result.size();
  }

  public static List combinArray(int target) {
    List<List<Integer>> result = new ArrayList<>();
    int[] a = {2, 3, 4};
    List<Integer> templist = new ArrayList<>();
    helper(result, templist, a, 7, 0);
    return result;
  }

  private static void helper(List<List<Integer>> result, List<Integer> tempList, int[] a,
      int target, int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      List<Integer> clone = new ArrayList<>(tempList);
      result.add(clone);
      return;
    }

    for (int i = start; i < a.length; i++) {
      tempList.add(a[i]);
      helper(result, tempList, a, target - a[i], i);
      tempList.remove(tempList.size() - 1);
    }

  }
}
