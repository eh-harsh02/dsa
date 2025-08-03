import java.util.Arrays;
import java.util.Scanner;
class coinChange{
    public int getWays(int[] coins, int n) {
        int m = coins.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0; 

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
            dp[j] += dp[j - coins[i]];
            }
        }
        return dp[n] - (n + 1) == 0 ? 0 : dp[n];
    
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[m];
        for(int i = 0; i < m; i++){
            coins[i] = sc.nextInt();
        }
        coinChange cc = new coinChange();
        int result = cc.getWays(coins, n);
        System.out.println(result);

    }
}