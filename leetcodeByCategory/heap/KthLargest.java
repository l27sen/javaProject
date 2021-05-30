package com.scotiabank.riskmanagement.testcdoe.heap;

import java.util.PriorityQueue;

/**
 * kth largest element in the stream.
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new
 * KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5 kthLargest.add(9);   // returns 8 kthLargest.add(4);   //
 * returns 8
 */
public class KthLargest {

  //小的在堆顶
  PriorityQueue<Integer> minHeap;
  int k;

  public KthLargest(int k, int[] nums) {
    this.minHeap = new PriorityQueue<Integer>();
    this.k = k;
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {

    if (minHeap.size() < k) {
      minHeap.add(val);
    } else if (minHeap.peek() < val) {
      minHeap.poll();
      minHeap.add(val);
    }
    return minHeap.peek();

  }
}
