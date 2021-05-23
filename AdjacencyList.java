
import java.util.*;

/* Undirected connected Graph.
(0)--------(1)------(3)
  \        /
    \ (2) /

Output : 0 1 2 3
*/

class AdjacencyList
{
    static int vertex = 5;
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int s, int v)
    {
        adj.get(s).add(v);
        adj.get(v).add(s);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> adj)
    {
        for(int i=0; i<adj.size(); i++)
        {
            for(int j=0; j<adj.get(i).size(); j++)
                System.out.print(adj.get(i).get(j) + " ");
            System.out.println();
        }
    }
     public static void main(String args[])
     {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<vertex; i++)
          adj.add(new ArrayList<Integer>());

          addEdges(adj, 0, 1);
          addEdges(adj, 0, 2);
          addEdges(adj, 1, 2);
          addEdges(adj, 1, 3);
          printGraph(adj);
     }
}