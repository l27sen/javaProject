package leetcodeByCategory.jacob;

/**
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeToSortedList {

    public CommoneList mergeTwo(CommoneList l1,  CommoneList l2){

        CommoneList dummy = new CommoneList(-1);
        CommoneList curr = dummy;
        while (l1.next!=null||l2.next!=null){
            int v1 = l1.next!=null? l1.value:Integer.MAX_VALUE;
            int v2 = l2.next!=null? l2.value:Integer.MAX_VALUE;

            if(v1<v2){
                curr.next = new CommoneList(v1);
                l1= l1.next;
            }else {
                curr.next = new CommoneList(v2);
                l2 = l2.next;
            }
            curr = curr.next;

        }
        return dummy.next;
    }
}
