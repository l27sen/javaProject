package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * input is array, [2,3,6,7]
 * <p>
 * if start is 7, then array is [2,2,3]
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        combine(array, 7);
    }

    public static List<List<Integer>> combine(int[] array, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        helper(resultList, new ArrayList<>(), array, target, 0);
        return resultList;
    }

    /**
     *
     * @param resultList result list
     * @param list each list that has sum value euqals target
     * @param array
     * @param target
     * @param start
     */
    public static void helper(List<List<Integer>> resultList, List<Integer> list,
                              int[] array, int target, int start) {

        if (target < 0) {
            return;
        }

        if (target == 0) {

            resultList.add(list);
        }

        for (int i = start; i < array.length; i++) {
            list.add(array[i]);
            helper(resultList, list, array, target - array[i], i);
            list.remove(list.size() - 1);
        }
    }
}
