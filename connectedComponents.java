import java.util.*;
public class connectedComponents {
    public static int[] connectedComponents(int[][] bg) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : bg) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                int size = dfs(node, graph, visited);
                if (size > 1) { 
                    min = Math.min(min, size);
                    max = Math.max(max, size);
                }
            }
        }
        return new int[]{min, max};
    }

    private static int dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited.add(node);
        int count = 1;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] bg = new int[N][2];
        for (int i = 0; i < N; i++) {
            bg[i][0] = sc.nextInt();
            bg[i][1] = sc.nextInt();
        }
        int[] result = connectedComponents(bg);
        System.out.println(result[0] + " " + result[1]);
    }
}
