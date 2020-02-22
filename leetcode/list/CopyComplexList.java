package leetcode.list;

public class CopyComplexList {

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode clone(RandomListNode pHead) {
        // 复制每一个结点（忽略random指针），与源结点共同组成一个两倍长度的新链表
        cloneNodes(pHead);
        // 设置random指针
        connectSiblingNodes(pHead);
        // 拆分链表，并返回复制的链表的表头
        return reconnectNodes(pHead);
    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode clone = new RandomListNode(pNode.label);
            clone.next = pNode.next;
            clone.random = null;
            pNode.next = clone;
            pNode = clone.next;
        }
    }

    /**
     * 设置复制结点的random指针，
     * 注意到复制结点的random指针应该指向相应的复制结点，
     * 而每一个复制结点都在它对应的源结点的next的位置上。
     * @param pHead
     */
    private void connectSiblingNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while(pNode != null) {
            RandomListNode clonedNode = pNode.next;
            if(pNode.random != null) {
                clonedNode.random = pNode.random.next;
            }
            pNode = clonedNode.next;
        }
    }

    /**
     * 将原链表和复制链表组成的长链表拆分成两个链表：
     * 奇数位置的结点链接起来就是原链表，
     * 偶数位置的结点链接起来就是复制出来的链表。
     * @param head 原链表和复制链表组成的长链表的表头
     * @return 复制出的链表的表头
     */
    private RandomListNode reconnectNodes(RandomListNode head) {
        // 当链表为空就直接返回空
        if (head == null) {
            return null;
        }
        // 用于记录复制链表的头结点
        RandomListNode newHead = head.next;
        // 用于记录当前处理的复制结点
        RandomListNode pointer = newHead;
        // 被复制结点的next指向下一个被复制结点
        head.next = newHead.next;
        // 指向新的被复制结点
        head = head.next;

        while (head != null) {
            // pointer指向复制结点
            pointer.next = head.next;
            pointer = pointer.next;
            // head的下一个指向复制结点的下一个结点，即原来链表的结点
            head.next = pointer.next;
            // head指向下一个原来链表上的结点
            head = pointer.next;
        }

        // 返回复制链表的头结点
        return newHead;

    }
}
