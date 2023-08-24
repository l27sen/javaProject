package leetcodeByCategory.jacob;

import java.util.*;

class Node{
    public  int value;
    public List<Node> neighbors;

    public Node(int value, List<Node> inputList){
        this.value = value;
        this.neighbors = inputList;

    }
}
public class CloneGraph {

    public Node clone(Node node){

        //key is old Node, value is new Node
       Map<Node,Node> map = new HashMap<>();
       copyNode(node, map);
       copyNei(node, map, new HashSet<>());
       return map.get(node);
    }

    private void copyNode(Node node, Map<Node,Node> map){
        if(map.containsKey(node))return;
        map.put(node, new Node(node.value, new ArrayList<>()));
         for( Node nei:node.neighbors){
             copyNode(nei,map);
         }
    }

    private void copyNei(Node node, Map<Node, Node> map, HashSet<Node> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        map.put(node, new Node(node.value, new ArrayList<>()));
        for (Node nei : node.neighbors) {
            //get new node neighbors, then add the new nei value
            map.get(node).neighbors.add(map.get(nei));
            copyNei(nei, map, visited);
        }
    }



}
