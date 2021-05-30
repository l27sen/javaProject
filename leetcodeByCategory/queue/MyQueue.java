package com.scotiabank.riskmanagement.testcdoe.queue;


class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

/**
 * 加入的时候加到尾巴
 * 取出的时候，从头开始
 */
public class MyQueue {

    Node first, last;

    //队列 新来的加尾巴
    public void enqueue(Node n){
        if(first == null){
            first = n;
            last = first;
        }else{
            last.next = n;
            last =n;
        }
    }

    public Node dequeue(){
        if(first == null){
            return null;
        }else{
            Node temp = new Node(first.val);
            first = first.next;
            return temp;
        }
    }

    public static void main(String[] a){
        MyQueue queue = new MyQueue();
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));

        System.out.println("deque value"+queue.dequeue().val);

        Node n =queue.first;

    }
}
