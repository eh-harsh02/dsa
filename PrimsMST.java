
import java.util.Arrays;

public class PrimsMST {
    int V; // tottal no. of vertices
        int[][] graph;
        PrimsMST(int V){
            this.V=V;
            this.graph=new int[V][V];
        }
         public int minVertex(boolean[] visited, int[] cost){
            int minCost = Integer.MAX_VALUE, minVertex=  -1;
            for(int i=0; i<V; i++){
                if(cost[i]<minCost && !visited[i]){
                    minVertex = i;
                    minCost = cost[i];
                }
            }
            return minVertex;
        }
        public int primsMST(int start, int[][] graph){
            boolean[] visited = new boolean[V];
            Arrays.fill(visited, false);
            int[] cost = new int[V];
            Arrays.fill(cost, Integer.MAX_VALUE);
            int[] parent = new int[V];
            Arrays.fill(parent, -1);
            cost[start] = 0;
            for(int i=0; i<V-1; i++){
                int U = minVertex(visited, cost);
                if(U==-1) continue;
                visited[U] = true;
                for(int v=0; v<V; v++){
                    if(graph[U][v] != 0 && graph[U][v] < cost[v] && !visited[v]){
                        cost[v] = graph[U][v];
                        parent[v] = U;
                    }
                }
            }
            int totalCost = 0;
            for(int i=0; i<V; i++){
                totalCost += cost[i];
            }
            return  totalCost;
        }
       
    public static void main(String[] args) {
        int V = 9;
        PrimsMST primsMST = new PrimsMST(V);
        // Example graph represented as an adjacency matrix
        primsMST.graph = new int[][]{
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int startVertex = 0; // Starting vertex for Prim's algorithm
        int totalCost = primsMST.primsMST(startVertex, primsMST.graph);
        System.out.println("Total cost of the Minimum Spanning Tree: " + totalCost);
        
    }
}
