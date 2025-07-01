import java.util.*;

public class findShortest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }

        // Read color ids of each node (1-based index)
        int[] colors = new int[n + 1]; // 1-based indexing
        for (int i = 1; i <= n; i++) {
            colors[i] = sc.nextInt();
        }

        // Read the target color to analyze
        int targetColor = sc.nextInt();

        // Find all nodes with target color
        List<Integer> targets = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (colors[i] == targetColor) {
                targets.add(i);
            }
        }

        if (targets.size() < 2) {
            System.out.println(-1);
            return;
        }

        int shortest = Integer.MAX_VALUE;

        // For each such node, run BFS to find nearest same-color node
        for (int start : targets) {
            int distance = bfs(start, targetColor, adj, colors);
            if (distance != -1) {
                shortest = Math.min(shortest, distance);
            }
        }

        System.out.println(shortest == Integer.MAX_VALUE ? -1 : shortest);
    }

    // BFS from 'start' to find the shortest path to another node with the same color
    private static int bfs(int start, int targetColor, List<List<Integer>> adj, int[] colors) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[colors.length];
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    if (colors[neighbor] == targetColor && neighbor != start) {
                        return dist + 1;
                    }
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return -1;
    }
}
// time complexity: O(n + m) for each BFS, where n is the number of nodes and m is the number of edges.
// The overall complexity is O(k * (n + m)), where k is the number of nodes with the target color.
// space complexity: O(n + m) for the adjacency list and O(n) for the visited array.
// This solution efficiently finds the shortest path between nodes of the same color in an undirected graph