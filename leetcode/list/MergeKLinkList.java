package leetcode.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLinkList {


    public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null||lists.size()==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.value - l2.value;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }
        return head.next;
    }

    public static void main(String[] a){
         ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node1.next = node2;

        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node3.next = node4;

        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(node1);
        listNodes.add(node3);

        mergeKLists(listNodes);


    }
}
