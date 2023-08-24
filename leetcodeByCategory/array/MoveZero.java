package leetcodeByCategory.array;

/**
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZero {

  public static void main(String a[]) {

    int[] inputArr = {0,1,0,3 ,12};
    moveZeroes(inputArr);

  }

  public void move(int[] num){
    int p =0;
    for (int i = 0; i < num.length ; i++) {

      if(num[i]!=0){
        num[p++]=num[i];
      }
    }

    for (int i = p; i < num.length ; i++) {
      num[i]=0;
    }
  }

  public static void moveZeroes(int[] nums) {

    for (int i = 0; i <nums.length-1 ; i++) {
      for (int j = i+1; j < nums.length; j++) {
        swap(nums,i, j);
      }
    }
     int a = nums.length;
  }


  private static void swap(int[] nums, int i, int j){

    if(nums[i]==0 && nums[j]!=0){

      int tmp = nums[i];
      nums[i] = nums[j];
          nums[j] =tmp;

    }

  }


}
