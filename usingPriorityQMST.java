import java.util.Arrays;
import java.util.PriorityQueue;

public class usingPriorityQMST {
    int V; // total number of vertices
    int[][] graph;

    usingPriorityQMST(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }

    // Prim’s algorithm using Priority Queue
    public int findMSTUsingPriorityQueue(int start, int[][] graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[V];
        int[] cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        pq.offer(new int[]{0, start});
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if (visited[u]) continue;
            visited[u] = true;
            mstWeight += curr[0];

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < cost[v]) {
                    cost[v] = graph[u][v];
                    pq.offer(new int[]{cost[v], v});
                }
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
    int V = 9;
    usingPriorityQMST primsMST = new usingPriorityQMST(V);

    int[][] sampleGraph = {
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

    int totalWeight = primsMST.findMSTUsingPriorityQueue(0, sampleGraph);
    System.out.println("Total weight of MST: " + totalWeight);
}
}
