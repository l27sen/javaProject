package leetcodeByCategory.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//O(Nlogk)
public class MergeKLinkList {


    public static ListNode22 mergeKLists(List<ListNode22> lists) {
        if(lists==null||lists.size()==0)
            return null;
        ListNode22 head = new ListNode22(0);

        ListNode22 p = head;

        PriorityQueue<ListNode22> queue = new PriorityQueue<>(new Comparator<ListNode22>() {
            @Override
            public int compare(ListNode22 o1, ListNode22 o2) {
                return o1.value-o2.value;
            }
        });
        for(ListNode22 list: lists){
            if(list!=null)
                queue.offer(list);

        }

        while(!queue.isEmpty()){
            ListNode22 n = queue.poll();
            p.next = n;
            p=p.next;

            //this part is important. because in the beginning only the first is added to queeu.
            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;
    }

    public static void main(String[] a){
         ListNode22 node1 = new ListNode22(1);
        ListNode22 node2 = new ListNode22(3);
        node1.next = node2;

        ListNode22 node3 = new ListNode22(2);
        ListNode22 node4 = new ListNode22(4);
        node3.next = node4;

        List<ListNode22> listNodes = new ArrayList<>();
        listNodes.add(node1);
        listNodes.add(node3);

        mergeKLists(listNodes);


    }
}
