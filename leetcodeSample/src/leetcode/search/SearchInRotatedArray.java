package leetcode.search;

public class SearchInRotatedArray {
    public static void main(String[] args) {

        int[] array = {3,4,5,6,7,1,2};
        System.out.println(search(array,1));
//        System.out.println(numWaysWithNoCache(5, coins,0));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;

            // 3,4,5,6,7,1,2 , case
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            //6,7,1,2,3,4,5
            else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }

}
