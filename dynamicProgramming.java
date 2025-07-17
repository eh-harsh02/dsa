import java.util.*;
public class dynamicProgramming {
    public static int fib(int N){
        HashMap<Integer, Integer> memo = new HashMap<>(); //Build a memo(DP)
        memo.put(0, 0); memo.put(1, 1); // prepopulate the memo which answer already known
        return fibUtil(N, memo);
    }
    public static int fibUtil(int N, HashMap<Integer, Integer> memo){
        if(memo.containsKey(N)) return memo.get(N);
        if(N<=1) return memo.get(N);
        int ans = fibUtil(N-1, memo) + fibUtil(N-2, memo);
        memo.put(N, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
