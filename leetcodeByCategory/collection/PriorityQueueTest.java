package leetcodeByCategory.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
 public static void main(String[]a ){
   PriorityQueue<Integer> priorityQueue = new PriorityQueue();

   priorityQueue.add(3);
   priorityQueue.add(2);



   System.out.println(priorityQueue.poll());
 }
}
