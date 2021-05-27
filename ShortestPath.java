
import java.util.*;
/*
    Shortest Path in Unweighted Graph.
     
     /--------------\ 
    (0)-----(2)-----(4)
     |       |       |
     |       |       |
     |       |       |
    (1)------(3)----(5)
    
Output : 0 1 1 2 1 2
*/
class ShortestPath
{
    static int v = 6;
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int s, int v)
    {
        adj.get(s).add(v);
        adj.get(v).add(s);
    }
    static void BFShelper(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited)
    {
        int dist[] = new int[v];
        for(int i=0; i<dist.length; i++)
        {
            dist[i] = -1;
        }        
        dist[s] = 0;
        visited[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while(!q.isEmpty())
        {
           int curr = q.poll();
           for(int v : adj.get(curr))
           {
               if(visited[v] == false)
               {
                   dist[v] = dist[curr] + 1;
                   visited[v] = true;
                   q.add(v);
               }
           }
        }
        for(int i=0; i<dist.length; i++)
          System.out.print(dist[i] + " ");
          System.out.println();
    } 
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<v; i++)
         adj.add(new ArrayList<Integer>());
      
      boolean visited[] = new boolean[v];
       addEdges(adj, 0, 1);
       addEdges(adj, 0, 2);
       addEdges(adj, 0, 4);
       addEdges(adj, 2, 3);
       addEdges(adj, 3, 1);
       addEdges(adj, 2, 4);
       addEdges(adj, 4, 5);
       addEdges(adj, 3, 5);
       BFShelper(adj, 0, visited);
    }
}