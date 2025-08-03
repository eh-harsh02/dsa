import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public int fibonacciModified(int t1, int t2, int n){
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].multiply(dp[i-1]).add(dp[i - 2]);
        }
        for(int idx = 0; idx < dp.length; idx++){
            if(dp[idx].equals(n)){
                return idx+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int n = sc.nextInt();
        Main obj = new Main();
        System.out.println(obj.fibonacciModified(t1, t2, n));
    }
}
