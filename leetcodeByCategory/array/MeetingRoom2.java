package leetcodeByCategory.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoom2 {

    public static void main(String[] a) {
        int[] ab = {0,30};

        int[] cd = {5,10};
        int[] e = {15,20};

        int[][] intervale = {ab, cd,e};

        System.out.print(minMeetingRooms(intervale));
    }

    public static  int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] each: intervals){

            //if smaller than the next , then mean can share.
            if(!pq.isEmpty() && pq.peek()< each[0]){
                pq.poll();
            }

            pq.add(each[1]);
        }

        return pq.size();
    }
}
