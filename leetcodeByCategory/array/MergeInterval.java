package leetcodeByCategory.array;

import java.util.*;

//example, (1,3),)(2,4)=> (1,4)
//1) 排序
//2） 比较  前一个的end 和下一个的开始， 如果end > start, merge
//3) else, add 前一个 to result list
class Interval {

    public int start;
    public int end;
}

public class MergeInterval {

    public static void main(String[] a) {
        Interval interval1 = new Interval();
        interval1.start = 1;
        interval1.end = 3;

        Interval interval2 = new Interval();
        interval2.start = 2;
        interval2.end = 6;

        Interval interval3 = new Interval();
        interval3.start = 7;
        interval3.end = 9;
        MergeInterval mergeInterval = new MergeInterval();
        List<Interval> result = mergeInterval.merge(Arrays.asList(interval1, interval2, interval3));
        result.size();
    }

    //Time complexity : O(nlog(n)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals, Comparator.comparing((Interval it) -> it.start));

        Interval t = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval c = intervals.get(i);
            //merge current to t, then skip the 'c' node,
            if (c.start <= t.end) {
                t.end = Math.max(t.end, c.end);
            } else {
                result.add(t);
                //must point to next element.
                t = c;
            }
        }

        //add the last element
        result.add(t);

        return result;
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
