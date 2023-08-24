package leetcodeByCategory.jacob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * O(n!)
 */
public class PerrmutationList {

    int k =0;
    public static void main(String[] a){
        PerrmutationList perrmutationList = new PerrmutationList();
        int[] array = {1,2};
        perrmutationList.permute(array);
    }

    public List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(),nums);

        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums){

        System.out.println("backtrack:"+k++ + Arrays.toString(tempList.toArray()));
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backtrack(result, tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }
}
