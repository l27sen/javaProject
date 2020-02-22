package leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Collections;
import java.util.PriorityQueue;

public class findMediaArrayElem {

    //head minnum number on top
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           // keeps track of the LARGE numbers
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of the SMALL numbers

    public static void main(String[] args) {

        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(5);

        maxHeap.add(4);
        maxHeap.add(3);
        maxHeap.add(2);
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());

    }
}
