package com.scotiabank.riskmanagement.testcdoe.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * input is array, [2,3,6,7]
 * <p>
 * if start is 7, then array is [2,2,3]
 *
 * 1) 定义resultList存结果， list存每次recurion的结果，
 * 2） recursion中，用循环从0开始， 遍历各种可能
 * 3） 要 list.remove(list.size() - 1);
 *
 * n! 复杂度
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        List<List<Integer>> result =   combine(array, 7);
        result.size();
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
            List<Integer> clone =new ArrayList<>(list);
            resultList.add(clone);
        }
        //i = start 排除重复
        //if i always start with 0, will genrate dupliate, like '2 2 3', '2 3 2'
        for (int i = start; i < array.length; i++) {
            list.add(array[i]);
            helper(resultList, list, array, target - array[i], i);
            //mean 'method returned  then removed the last value and try another
            //
            list.remove(list.size() - 1);
        }
    }
}
