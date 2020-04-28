import java.util.*;
public class Adjacency_list {
	
    int vertex;
    LinkedList<Integer> list[];
  
 public Adjacency_list(int vertex){
	 this.vertex = vertex;
	 list = new LinkedList[vertex];
	 for(int i=0; i<vertex; i++) {
		 list[i] = new LinkedList<>();
	 }
 }
 public void addEdge(int source, int destination) {
	 
	 //add edge for directed graph
	 list[source].addFirst(destination);
	 
	 //add edge for undirected graph
	 list[destination].addFirst(source);
 }
 public void printGraph() {
	 
	   for(int i=0; i<vertex; i++) {
		     if(list[i].size() > 0) {
		    	 System.out.print("vertex" + i + " is connected to: ");
		    	 for(int j=0; j<list[i].size(); j++) {
		    		 System.out.print(list[i].get(j) + " ");
		    	 }
		     System.out.println();
		     continue;
		     }
		     System.out.print("vertex" + i + " is connected to: " + "[]");
		     System.out.println();
	   }
 }
	public static void main(String[] args) {
	
        Adjacency_list graph = new Adjacency_list(7);
         graph.addEdge(0,1);
         graph.addEdge(0,2);
         graph.addEdge(1,2);
         graph.addEdge(2,3);
         graph.addEdge(3,4);
         graph.addEdge(3,5);
         graph.addEdge(4,6);
         graph.printGraph();
	}

}
