package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFSIterative {
    // This class represents a directed graph using adjacency list
// representation

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    GraphDFSIterative(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[]) {


        Stack<Integer> stack= new Stack<>();

        stack.push(v);

        while(!stack.isEmpty()){

            int n=stack.peek();
            stack.pop();

            if(visited[n]==false) {
                visited[n] = true;
                System.out.print(n+"  ");
            }

            Iterator<Integer> it =adj[n].listIterator();

            while(it.hasNext()){
                int node=it.next();
                if(!visited[node]){

                    stack.push(node);
                }

            }


        }



    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);

        boolean visited2[] = new boolean[V];
        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i=0; i<V; ++i)
            if (visited2[i] == false)
                DFSUtil(i, visited2);
    }

    public static void main(String args[])
    {
        GraphDFSIterative g = new GraphDFSIterative(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is Depth First Traversal Iterative"+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
