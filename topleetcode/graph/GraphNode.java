package topleetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    int val;
     List<GraphNode> neighbors;
    boolean visited;

    GraphNode(int x) {
        val = x;
        neighbors = new ArrayList<>();
    }



}
