
import java.util.*;

/*
 //Directed Acyclic Graph
   (5)           (4)
    |   \        / |
    |     \     /  |
    |     \/  \/   |
   \/      (0)    (1)
   (2)            /\
      \           /
        \        /  
         \ /   /
          (3) 

Output: 5 4 2 3 1 0 
*/

class TopologicalSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0)
        {
            int V = sc.nextInt();
            int e = sc.nextInt();
             ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
               for(int i=0; i<V; i++)
                 adj.add(new ArrayList<Integer>());
            for(int i=1; i<=e; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }
          DFSRec(adj, V);
        }
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int v)
    {
         boolean vis[] = new boolean[v];
         Stack<Integer> s = new Stack<>();
         for(int i=0; i<v; i++)
         {
             if(vis[i] == false)
               s = DFSHelper(adj, i, vis, s);
         }
         while(!s.isEmpty())
         {
             System.out.print(s.peek() + " ");
             s.pop();
         }
         System.out.println();
    }
    static Stack<Integer> DFSHelper(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], Stack<Integer> st)
    {
        //Stack<Integer> st = new Stack<>();
        vis[s] = true;
        for(int u : adj.get(s))
        {
             if(vis[u] == false)
             DFSHelper(adj, u, vis, st);
        }
        st.push(s);
        return st;
    }
 
}