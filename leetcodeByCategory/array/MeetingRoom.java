package leetcodeByCategory.array;

import java.util.Arrays;

// [0,30], [5,10]=> false, meeting time has conflict
// [2,4]  [7, 10], meeting time has conflict
//算法， 按照开始时间排序， 然后遍历 判断
public class MeetingRoom {

  public static void main(String[] a){
    int[] ab ={1,3};

    int[] cd ={2,4};
    int[][] intervale = {ab, cd};

    System.out.print(canMeeting(intervale));
  }

  public  static boolean canMeeting(int[][] intervals){

    //sort each element with the first array value.
    Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
    int last = -1;
    for (int[] each:intervals) {

      if(each[0]< last){
        return false;
      }
      last = each[1];

    }


    return true;
  }
}
