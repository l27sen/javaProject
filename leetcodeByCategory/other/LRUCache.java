package leetcodeByCategory.other;

import java.util.HashMap;
import java.util.Map;

/**
 * remove always remove head,
 * add to the end.
 *
 * The key at the front of the queue is the least recently used key,
 * and the key at the back of the queue is the most recently used key
 *
 *  * Time complexity: O(1)O(1)O(1)
 *  * Space complexity: O(capacity)
 */
public class LRUCache {

    //double linked list
    static class Node{
        Node(String key, String value){
            this.value = value;
            this.key = key;
        }
        String value;
        String key;
        Node next;
        Node pre;
    }

    private Node head;
    private Node end;

    private int limit;
    private Map<String,Node> hashMap;

    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    /**
     * add to the end
     * @param node
     */
    private void addNode(Node node){
        if(end!=null){
            end.next =node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if(head == null){
            head = node;
        }
    }


    //remove node, 3 cases.
    // endcase, head case, or middle case.
    private String removeNode(Node node){
        if(node == end){
            end = end.pre;
        }else if (node == head){
            head = head.next;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    //1) > limit, then removehead,
     //2) put, exist, refresh, not exist, then addNode.
    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    private void refreshNode(Node node){
        if(node == end){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private String get(String key){
        Node node = hashMap.get(key);
        if(node ==null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("1","user 1");
        lruCache.put("2","user 2");
        lruCache.put("3","user 3");
        lruCache.put("4","user 4");
        lruCache.put("5","user 5");
        lruCache.put("6","user 6");

        System.out.println(lruCache.get("1"));
    }

}
