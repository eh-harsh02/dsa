import java.util.Arrays;

public class knapSackProblem {
    // Memoization DP table (for top-down)
    static int[][] dp = new int[1001][1001];

    // ---------------------------------------------------
    // 1. Recursive solution (Brute Force) -> O(2^n)
    // ---------------------------------------------------
    static int knapsack(int W, int[] val, int[] wt, int n) {
        // Base case: no items left or knapsack capacity = 0
        if (n == 0 || W == 0) return 0;

        // If current item can fit in the knapsack
        if (wt[n - 1] <= W) {
            // Either include it OR exclude it → take max profit
            return Math.max(
                val[n - 1] + knapsack(W - wt[n - 1], val, wt, n - 1), // include item
                knapsack(W, val, wt, n - 1) // exclude item
            );
        } else {
            // If item is too heavy, we must exclude it
            return knapsack(W, val, wt, n - 1);
        }
    }

    // ---------------------------------------------------
    // 2. Top-Down DP with Memoization -> O(n * W)
    // ---------------------------------------------------
    static int memo(int W, int val[], int wt[], int n) {
        // Base case
        if (n == 0 || W == 0) return 0;

        // Return already computed result (avoids recomputation)
        if (dp[n][W] != -1) return dp[n][W];

        // If item can be included
        if (wt[n - 1] <= W) {
            // Store and return the best of including or excluding item
            return dp[n][W] = Math.max(
                val[n - 1] + memo(W - wt[n - 1], val, wt, n - 1), // include
                memo(W, val, wt, n - 1) // exclude
            );
        } else {
            // Item too heavy → exclude it
            return dp[n][W] = memo(W, val, wt, n - 1);
        }
    }

    // ---------------------------------------------------
    // 3. Bottom-Up DP (Tabulation) -> O(n * W)
    // ---------------------------------------------------
    static int tabulation(int W, int[] val, int[] wt, int n) {
        int[][] t = new int[n + 1][W + 1]; // DP table

        // Initialization: 0 items OR 0 capacity → profit = 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) t[i][j] = 0;
            }
        }

        // Build table iteratively
        for (int i = 1; i <= n; i++) { // loop over items
            for (int j = 1; j <= W; j++) { // loop over capacities
                if (wt[i - 1] <= j) {
                    // Choice: take item OR skip it
                    t[i][j] = Math.max(
                        val[i - 1] + t[i - 1][j - wt[i - 1]], // include item
                        t[i - 1][j] // exclude item
                    );
                } else {
                    // Item too heavy → skip it
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Final answer = best profit with all items and full capacity
        return t[n][W];
    }

    // ---------------------------------------------------
    // Main function to test all approaches
    // ---------------------------------------------------
    public static void main(String[] args) {
        int[] val = {1, 4, 5, 7}; // values of items
        int[] wt = {1, 3, 4, 5};  // weights of items
        int W = 7;                // knapsack capacity
        int n = val.length;       // number of items

        // Initialize memoization table with -1
        for (int[] row : dp) Arrays.fill(row, -1);

        // Run all three approaches
        System.out.println(knapsack(W, val, wt, n));   // Recursive
        System.out.println(memo(W, val, wt, n));       // Memoization
        System.out.println(tabulation(W, val, wt, n)); // Tabulation
    }
}
