package leetcodeByCategory.jacob;

public class RemoveNFromEndList {

    public CommoneList removeN(CommoneList head, int n){

        CommoneList dummy = head;

        CommoneList first = dummy;
        CommoneList second = dummy;

        for (int i = 0; i < n ; i++) {
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
