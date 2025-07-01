import java.util.*;
public class Solution {
    public static int[] bfs(int n, List<List<Integer>> adj, int s) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 6;
                    queue.add(v);
                }
            }
        }
        
        int[] result = new int[n - 1];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                result[idx++] = dist[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int qi = 0; qi < q; qi++) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = scn.nextInt();
                int v = scn.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int s = scn.nextInt();
            int[] res = bfs(n, adj, s);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
                if (i < res.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
        scn.close();
    }
}
// time complexity: O(n + m) where n is the number of nodes and m is the number of edges
// space complexity: O(n + m) for the adjacency list and distance array