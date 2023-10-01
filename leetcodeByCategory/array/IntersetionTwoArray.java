package leetcodeByCategory.array;

import java.util.*;

/**
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 */
public class IntersetionTwoArray {

    public static void main(String[] ar) {
        int[] a1 = {1, 1, 2, 2};
        int[] a2 = {2, 2};

        Integer[] result = getSame(a1, a2);
        System.out.println(result);
    }

    public static Integer[] getSame(int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i], map.getOrDefault(num1[i], 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < num2.length; j++) {
            if (map.containsKey(num2[j]) && map.get(num2[j]) > 0) {
                result.add(num2[j]);
                map.put(num2[j], map.get(num2[j]) - 1);
            }

        }
        return result.toArray(new Integer[result.size()]);


    }


   // O(n+m) in the average case.
    //思路： 把数组，存到两个set里面，然后比较
    public int[] set_intersection(HashSet <Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }
}
