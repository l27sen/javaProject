package com.scotiabank.riskmanagement.testcdoe.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxNumInWindow {

  List<Integer> result = new ArrayList<>();

  public static void main(String[] a) {
    int[] array = {2, 1, 3, 4, 5};
    List resultList = maxInWindows_2(array, 2);
    resultList.size();
  }

  //暴力发
  public List<Integer> getMaxWindows(int[] a, int windowSize) {
    int indexLengh = a.length - windowSize + 1;
    for (int i = 0; i < indexLengh; i++) {
      int end = i + windowSize - 1;
      result.add(maxNum(a, i, end));
    }
    return result;

  }


  public int maxNum(int[] num, int inx, int end) {
    int max = num[inx];
    for (int i = inx; i <= end; i++) {
      if (num[i] > max) {
        max = num[i];
      }
    }
    return max;
  }

  public static ArrayList<Integer> maxInWindows_2(int[] num, int size) {
    ArrayList<Integer> res = new ArrayList<>();
    if (size > num.length || size < 1) {
      return res;
    }
    // 构建最大堆，即堆顶元素是堆的最大值。
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    for (int i = 0; i < size; i++) {
      heap.add(num[i]);
    }
    res.add(heap.peek());
    //head 把元素加入的时候会自动排序
    for (int i = 1; i + size - 1 < num.length; i++) {
      heap.remove(num[i - 1]);
      //重点 i+size -1
      heap.add(num[i + size - 1]);
      res.add(heap.peek());
    }
    return res;
  }

}
