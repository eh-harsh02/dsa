public class subSetSum {
    // DP table: t[i][j] = true if subset of first i elements has sum j
    static boolean[][] t = new boolean[201][10001]; 

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        // STEP 1: Initialize DP table
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i == 0) t[i][j] = false;  // If no elements, sum cannot be formed
                if(j == 0) t[i][j] = true;   // Sum = 0 is always possible (empty subset)
            }
        }
        
        // STEP 2: Fill DP table (Bottom-Up)
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(arr[i - 1] <= j) {
                    // Choice: include arr[i-1] OR exclude it
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    // Cannot include arr[i-1], so inherit result from previous row
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Final answer: can we form sum using all n elements?
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }
}
