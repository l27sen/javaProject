package leetcode.array;

import java.util.*;

class Interval{
    public int start;
    public int end;
}
public class MergeInterval {

    public static void main(String[] a){
        Interval interval1 = new Interval();
        interval1.start =1;
        interval1.end = 3;

        Interval interval2 = new Interval();
        interval2.start =2;
        interval2.end = 6;

        Interval interval3 = new Interval();
        interval3.start =7;
        interval3.end = 9;
        MergeInterval mergeInterval  = new MergeInterval();
        List<Interval> result =mergeInterval.merge(Arrays.asList(interval1,interval2,interval3));
        result.size();
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size()<=1){
            return intervals;
        }

        Collections.sort(intervals, Comparator.comparing((Interval itl)->itl.start));

        List<Interval> result = new ArrayList<>();
        Interval t = intervals.get(0);

        for(int i=1; i<intervals.size(); i++){
            Interval c = intervals.get(i);
            if(c.start <= t.end){
                t.end = Math.max(t.end, c.end);
            }else{
                result.add(t);
                t = c;
            }
        }
        result.add(t);
        return result;
    }
}
