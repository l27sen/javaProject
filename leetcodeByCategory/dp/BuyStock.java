package leetcodeByCategory.dp;

public class BuyStock {

   int getProfix(int[] nums){
     int profit =0;
     if ( nums.length == 0) {
       return 0;
     }
     int min =nums[0];
     //找到最小的，比较 num[i]和最小的差值
     for (int i = 1; i < nums.length; i++) {
       min = Math.min(nums[i], min);

       profit = Math.max(nums[i]- min, profit);
     }

     return profit;

   }

}
