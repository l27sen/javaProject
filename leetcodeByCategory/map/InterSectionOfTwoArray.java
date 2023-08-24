package leetcodeByCategory.map;

import java.util.HashSet;

/**
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 我们可以用个 HashSet 把 nums1 都放进去，然后遍历 nums2 的元素，如果在 HashSet 中存在，
 * 说明是交集的部分，加入结果的 HashSet 中，最后再把结果转为 vector 的形式即可
 */
public class InterSectionOfTwoArray {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for(int i: nums1){
      set1.add(i);
    }

    HashSet<Integer> set2 = new HashSet<Integer>();
    for(int i: nums2){
      if(set1.contains(i)){
        set2.add(i);
      }
    }

    int[] result = new int[set2.size()];
    int i=0;
    for(int n: set2){
      result[i++] = n;
    }

    return result;
  }
}
