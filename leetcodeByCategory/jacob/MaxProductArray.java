package leetcodeByCategory.jacob;

public class MaxProductArray {

    public int maxProduct(int[] nums){
        if(nums==null||nums.length ==0) return 0;

        int max =nums[0];
        int min =nums[0];
        int res =nums[0];

        for (int i = 0; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max* nums[i], min* nums[i]), nums[i]);
            min = Math.max(Math.min(min* nums[i], tmp* nums[i]), nums[i]);

            res = Math.max(max,min);
        }

        return res;
    }
}
