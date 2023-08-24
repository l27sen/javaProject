package leetcodeByCategory.jacob;
class ListNode{
    ListNode next;
}
// 1,2,3,4,5, if k =2,then result is 4,5,1,2,3
public class RotateNode {

    ListNode rotate(ListNode head, int k){
       ListNode index = head;
       int length = 1;
       while(index.next!=null){
           index = index.next;
           length++;
       }

       //make it loop
        index.next = head;

       for(int i=1;i< length- k%length;i++){
           head = head.next;
       }
       // get the new head, like '4'
        ListNode result = head.next;
         // 'make ' 3->next is null;
        head.next =null;

        return null;

    }
}
