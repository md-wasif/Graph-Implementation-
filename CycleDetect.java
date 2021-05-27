
import java.util.*;

/*
  (0)----->(1)
  / \       /
   |       /
   |      / 
   |     /
    \  \ /
     (2)------->(3)

  Output : 1;
  */

class CycleDetect
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
               adj.get(v).add(u);
           }
           DFSREC c = new DFSREC();
           boolean flag = c.checkCycle(adj, V);
           if(flag)
             System.out.print("1");
           else
             System.out.print("0");

             
         System.out.println();
        }
    }
}

class DFSREC
{
     public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int v)
     {
         boolean visited[] = new boolean[v];
         for(int i=0; i<v; i++)
            if(!visited[i] && DFSUtill(adj, i, visited, -1))
              return true;
               
        return false;
     }
     static boolean DFSUtill(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent)
     {
         vis[s] = true;
         for(int u : adj.get(s))
         {
             if(vis[u] == false){
             if(DFSUtill(adj, u, vis, s) == true)
               return true;
             }
            else if(u != parent)
              return true;
         }
         return false;
     }
}