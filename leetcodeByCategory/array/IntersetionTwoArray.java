package leetcodeByCategory.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
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
}
