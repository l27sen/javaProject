package leetcodeByCategory.graphic;

import java.util.Iterator;
import java.util.LinkedList;

//for every visted 'v' , if there is adjenct 'u' is visted,
// and u is not parent of V, then cycle found.
class Graph {

  // No. of vertices 顶点
  private int V;

  // Adjacency List Represntation
  private LinkedList<Integer> adj[];

  // Constructor
  Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList();
    }
  }

  // Function to add an edge
  // into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  // A recursive function that
  // uses visited[] and parent to detect
  // cycle in subgraph reachable
  // from vertex v.
  Boolean isCyclicUtil(int v,
      Boolean visited[], int parent) {
    // Mark the current node as visited
    visited[v] = true;
    Integer i;
    // Recur for all the vertices
    // adjacent to this vertex
    Iterator<Integer> it = adj[v].iterator();
    while (it.hasNext()) {
      i = it.next();

      // If an adjacent is not
      // visited, then recur for that
      // adjacent
      //父节点是V， 因为从V开始
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, v)) {
          return true;
        }
      }

      // If an adjacent is visited
      // and not parent of current
      // vertex, then there is a cycle.
      else if (i != parent) {
        return true;
      }
    }
    return false;
  }

  // Returns true if the graph
  // contains a cycle, else false.
  Boolean isCyclic() {

    // Mark all the vertices as
    // not visited and not part of
    // recursion stack
    Boolean visited[] = new Boolean[V];
    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }

    // Call the recursive helper
    // function to detect cycle in
    // different DFS trees
    for (int u = 0; u < V; u++) {

      // Don't recur for u if already visited
      if (!visited[u]) {
        if (isCyclicUtil(u, visited, -1)) {
          return true;
        }
      }
    }

    return false;
  }


}

public class DetectCycle {

  // Driver method to test above methods
  public static void main(String args[]) {

    // Create a graph given
    // in the above diagram
    Graph g1 = new Graph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (g1.isCyclic()) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph doesn't contains cycle");
    }

    Graph g2 = new Graph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    if (g2.isCyclic()) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph doesn't contains cycle");
    }
  }
}
