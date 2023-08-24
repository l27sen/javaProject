package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.List;

//[1,2,3,4]->> [1,2],[1,3],[1,4],[2,3],[2,4],[3,4]
public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>(), 0, 2);
        return res;

    }

    /**
     * @param res
     * @param nums
     * @param tmp
     * @param startIndex
     * @param count      limit only 'k' numbers in array.
     */
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> tmp, int startIndex, int count) {

        if (count == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(res, nums, tmp, i + 1, count-1);
            tmp.remove(tmp.size() - 1);

        }
    }
}
