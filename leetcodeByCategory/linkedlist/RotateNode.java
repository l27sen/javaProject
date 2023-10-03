package leetcodeByCategory.linkedlist;
class ListNode6{
    ListNode6 next;
}
// 1,2,3,4,5, if k =2,then result is 4,5,1,2,3
//O(N)
public class RotateNode {

    ListNode rotate(ListNode6 head, int k){
        ListNode6 index = head;
       int length = 1;
       //get length
       while(index.next!=null){
           index = index.next;
           length++;
       }

       //make it loop， last node point to head
        index.next = head;

       //go to middle node
       for(int i=0;i< length- k%length-1;i++){
           head = head.next;
       }
       // get the new head, like '4'
        ListNode6 result = head.next;
         // 'make ' 3->next is null;
        head.next =null;

        return null;

    }
}
