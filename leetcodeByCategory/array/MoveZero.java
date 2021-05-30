package com.scotiabank.riskmanagement.testcdoe.array;

/**
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZero {

  public static void main(String a[]) {

    int[] inputArr = {0,1,0,3 ,12};
    moveZeroes(inputArr);

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
