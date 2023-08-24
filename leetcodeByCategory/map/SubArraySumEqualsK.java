package leetcodeByCategory.map;

import java.util.HashMap;

/**
 * input:nums = [1,1,1], k = 2 Output: 2
 * input:nums = [1,2,3], k = 6 Output: 2
 */
public class SubArraySumEqualsK {

  public static void main(String[] a) {

    int[] abc = {1, 2, 3};
    System.out.println(subarraySum(abc, 3));
  }

  //prefix sum algorism
  public static int subarraySum(int[] nums, int k) {
    //存储Sum值为Key， value为出现的次数
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int count = 0;
    int sum = 0;

    //e.g., 1 1 2 1 1
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      //这个是关键 不仅包括0， 包括之前出现的Sum -k
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}
