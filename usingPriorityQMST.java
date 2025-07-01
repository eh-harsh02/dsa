public class usingPriorityQMST {
    int V; // tottal no. of vertices
        int[][] graph;
        usingPriorityQMST(int V){
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
    public static void main(String[] args) {
        
    }
}
