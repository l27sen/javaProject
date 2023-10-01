package leetcodeByCategory.jacob;

/**
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNFromEndList {

    //思路就是找到要remove的节点
    public CommoneList removeN(CommoneList head, int n){

        CommoneList dummy = head;

        CommoneList first = dummy;
        CommoneList second = dummy;

      //正向走到N
        for (int i = 0; i < n ; i++) {
            first = first.next;
        }
        //走到要remove得节点
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;


        return dummy.next;
    }
}
