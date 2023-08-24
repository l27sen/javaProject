package leetcodeByCategory.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 */
public class Permutation2 {

    public static void main(String[] a){

        int[] array = {1,1,2};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[array.length];
        helper(res, curr, array, visited);
        res.size();
    }
    public static void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {

        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;


        }


    }
}
