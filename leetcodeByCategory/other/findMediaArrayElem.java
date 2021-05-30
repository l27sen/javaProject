package com.scotiabank.riskmanagement.testcdoe.other;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Collections;
import java.util.PriorityQueue;

public class findMediaArrayElem {

    //head minnum number on top //store big number
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           // keeps track of the LARGE numbers
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of the SMALL numbers

    public static void main(String[] args) {

        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);

        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(0);
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());

    }
}
