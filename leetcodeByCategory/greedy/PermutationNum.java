package com.scotiabank.riskmanagement.testcdoe.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3] have the following permutations: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * ]
 */
public class PermutationNum {

  public static void main(String[] args) {
    PermutationNum permutationNum = new PermutationNum();
    int[] abc = {1, 2};
    List<List<Integer>> list = permutationNum.permute(abc);
    list.size();
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();

    backtrack(list, new ArrayList<>(), nums);
    return list;
  }

  private void backtrack(List<List<Integer>> list,
      List<Integer> tempList, int[] nums) {

    if (tempList.size() == nums.length) {
      //must use new ArrayList
      list.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (tempList.contains(nums[i])) {
        continue;
      }
      tempList.add(nums[i]);
      backtrack(list, tempList, nums);
      tempList.remove(tempList.size() - 1);
    }
  }
}
