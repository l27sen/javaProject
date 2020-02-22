package topleetcode.graph;


import java.util.HashMap;

public class CloneGraph {

    static HashMap<GraphNode, GraphNode> map = new HashMap<>();

    public static GraphNode cloneGraph(GraphNode node) {
        return helper(node);
    }

    //clone by DFS.
    public static GraphNode helper(GraphNode node) {

        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        GraphNode graphNodeClone = new GraphNode(node.val);
        for (GraphNode neighBoer : node.neighbors) {
            GraphNode cloneNeigh = helper(neighBoer);
            graphNodeClone.neighbors.add(cloneNeigh);
        }
        return graphNodeClone;
    }

    public static void main(String[] a) {
        GraphNode graphNode = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);

        graphNode.neighbors.add(graphNode2);
        graphNode2.neighbors.add(graphNode3);

        GraphNode clone = cloneGraph(graphNode);
        System.out.println(clone.neighbors);

    }
}
