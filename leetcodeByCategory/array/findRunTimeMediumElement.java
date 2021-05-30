package com.scotiabank.riskmanagement.testcdoe.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 到一个数据流中的中位数
 * maxHeap store smaller num, 大的在最前面先出，
 * 1) size is the same, compare input the minHeap first value
 * 2) maxheap size is bigger, compare with MaxHeap first value
 */
public class findRunTimeMediumElement {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of the SMALL numbers
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           // keeps track of the LARGE numbers


    public static void main(String[] a){
        int[] inputArr = {45,23,11,89};
        medianTracker(inputArr);
    }

    public static void medianTracker(int [] array) {
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
        }
        System.out.println(getMedian());

    }

    /**
     * add number to heap
     * @param i
     */
    public static  void addNumber(int i) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(i);
        } else if (maxHeap.size() == minHeap.size()) {
            if (i < minHeap.peek()) {
                maxHeap.add(i);
            } else {
                minHeap.add(i);
                //move the smallest element to maxHeap
                maxHeap.add(minHeap.remove());
            }

        } else if (maxHeap.size() > minHeap.size()) {
            if (i > maxHeap.peek()) {
                minHeap.add(i);
            } else {
                minHeap.add(maxHeap.remove());
                maxHeap.add(i);
            }
        }
        // maxHeap will never have fewer elements than minHeap
    }

    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { // maxHeap must have more elements than minHeap
            return maxHeap.peek();
        }
    }
}
