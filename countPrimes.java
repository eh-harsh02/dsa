import java.util.Scanner;
// Use Sieve of Eratosthenes
// TC--> O(n log log n)
// SC--> O(n) for the prime[] array
public class countPrimes {
    public int countPrime(int n) {
        int[] prime = new int[n+1];
        for(int i=2; i<n; i++){
            prime[i] = 1;
        }
        for(int i=2; i*i<=n; i++){
            if(prime[i]==1){
                for(int j = i*i; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }
        int count=0;
        for(int i=2; i<n; i++){
            if(prime[i]==1) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        countPrimes obj = new countPrimes();
        int ans = obj.countPrime(n);
        System.out.println(ans);
        scn.close();
    }
    
}


    
