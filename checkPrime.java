import java.util.Scanner;
public class checkPrime {

    public static boolean isPrime(int n){
        if(n<=1) return false;
        int count = 2;
        while(count*count<=n){
            if(n%count==0) return false;
            count++;
        }
        return count*count >n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrime(n));
        sc.close();
    }
}
