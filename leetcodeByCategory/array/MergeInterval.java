package com.scotiabank.riskmanagement.testcdoe.array;

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

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
      return intervals;
    }

    //sort first
    Collections.sort(intervals, Comparator.comparing((Interval itl) -> itl.start));

    List<Interval> result = new ArrayList<>();
    Interval t = intervals.get(0);

    for (int i = 1; i < intervals.size(); i++) {
      Interval c = intervals.get(i);
      //merge current to t, then skip the 'c' node,
      if (c.start <= t.end) {
        t.end = Math.max(t.end, c.end);
      } else {
        result.add(t);
        t = c;
      }
    }
    result.add(t);
    return result;
  }
}
