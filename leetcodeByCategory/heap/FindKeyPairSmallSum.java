package leetcodeByCategory.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//利用heap 存数组对， 比较大小
public class FindKeyPairSmallSum {


  public static void main(String[] a){
    int[] b ={1, 3, 5};

    int[] c ={2, 4, 8};
    List<List<Integer>> list = kSmallestPairs(b, c, 2);
    System.out.println(list);

  }
  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      //小的在前面
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1]+o2[0]- o1[1]-o1[0];
      }
    });


    for (int i = 0; i < nums1.length; ++i) {
      for (int j = 0; j < nums2.length; ++j) {
        if (j >= k) {
          break;
        }

        pq.add(new int[]{nums1[i], nums2[j]});
        if (pq.size() > k) {
          pq.poll();
        }
      }
    }
    LinkedList<List<Integer>> all = new LinkedList<>();
    while (pq.size() > 0) {
      int[] item = pq.poll();
      List<Integer> list = new ArrayList<>();
      list.add(item[0]);
      list.add(item[1]);
      all.addFirst(list);
    }
    return all;
  }
}
