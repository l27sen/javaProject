package company.bloomberg;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 *
 * //思路，把不需要 precourse的课加入， 然后遍历其他的课，再减，如果有课可以修了，加入queue
 */
public class CourseRechedule {


    public boolean canFinish(int numCourse, int[][] preCourse) {

        //one course need how manch precourse
        int[] courseCount = new int[numCourse];

        for (int[] each : preCourse) {

            courseCount[each[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourse; i++) {
            //add counse that require zero dependency to queue.
            if (courseCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] each : preCourse) {

                if (courseCount[each[0]] == 0) {
                    continue;
                }
                if (each[1] == curr) {
                    courseCount[each[0]]--;
                }
                if (courseCount[each[0]] == 0) {
                    //this couse can be added to queue
                    queue.offer(each[0]);
                }
            }
        }

        for (int i = 0; i < numCourse; i++) {
            //add counse that require zero dependency to queue.
            if (courseCount[i] != 0) {
               return false;
            }
        }

        return true;
    }
}
