
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V; // tottal no. of vertices
        int[][] graph;
        Graph(int V){
            this.V=V;
            this.graph=new int[V][V];
        }

        public void bfs(int start){
            boolean visited[] = new boolean[V];
            Arrays.fill(visited, false);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            
            while(!queue.isEmpty()){
                int removed = queue.remove();
                System.out.print(removed+" ");
                for(int i=0; i<V; i++){
                if(graph[removed][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
                }
            }
        }

        public void dfs(int start){
            boolean[] visited = new boolean[V];
            Arrays.fill(visited, false);
            dfsUtil(start, visited);
        }

        public void dfsUtil(int start, boolean[] visited){
            System.out.print(start+" ");
            visited[start]=true;
            for(int i=0; i<V; i++){
                if(graph[start][i]==1 && !visited[i]){
                    dfsUtil(i, visited);
                }
            }
        }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.graph = new int[][]{
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
        };
        System.out.println();
        graph.bfs(0);
        System.out.println();
        graph.bfs(1);
        System.out.println();
        graph.bfs(2);
        System.out.println();
        graph.dfs(0);
    }
}
