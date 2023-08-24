package leetcodeByCategory.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3] have the following permutations: [ 1, 2, 3, 12, 13,23, 123. ]
 */
public class SubSetArray {

    public static void main(String[] args) {
        SubSetArray permutationNum = new SubSetArray();
        int[] abc = {1, 2};
        List<List<Integer>> list = permutationNum.permute(abc);
        list.size();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();

        getSubSet(subSets, new ArrayList<>(), nums, 0);
        return subSets;
    }

    private void getSubSet(List<List<Integer>> list, List<Integer> currentList, int[] nums,
                           int index) {

        list.add(new ArrayList<>(currentList));

        //from index
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            getSubSet(list, currentList, nums, i + 1);
            currentList.remove(currentList.size() - 1);
        }

    }


}
