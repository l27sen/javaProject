package leetcodeByCategory.array;

import java.util.HashSet;
import java.util.Set;

/**
 * [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its
 * length is 4.
 *
 * Time complexity : O(n)O(n)O(n)
 *
 * 思路： 用 set 存起来，然后比较 o(N)，比较数字周围的value 是否被包含，然后删掉set里面的value
 */
public class LongestConsecutiveArray {

  public static void main(String[] a) {
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(longestConsecutive(nums));
  }

  //leetcode solution

  public static int longestConsecutiveCount(int[] nums) {
    Set<Integer> num_set = new HashSet<Integer>();
    for (int num : nums) {
      num_set.add(num);
    }

    int longestStreak = 0;

    for (int num : num_set) {
      //from smallest one
      //if (!num_set.contains(num-1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (num_set.contains(currentNum+1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      //}
    }

    return longestStreak;
  }

  public static int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int result = 0;

    //针对每个数，向上或者向下加减
    for (int num : nums) {
      int count = 1;
      int down = num - 1;
      while (set.contains(down)) {
        set.remove(down);
        down--;
        count++;
      }

      int up = num + 1;
      while (set.contains(up)) {
        set.remove(up);
        up++;
        count++;
      }

      result = Math.max(result, count);
    }

    return result;
  }
}
