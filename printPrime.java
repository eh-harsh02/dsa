import java.util.Scanner;
public class printPrime {
    public static boolean primeNo(int terms){
        for(int i=2; i<=Math.sqrt(terms); i++){
            if(terms%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int terms = sc.nextInt();
        for(int i=2; i<=terms; i++){
            if(primeNo(i)){
                System.out.print(i+" ");
            }
        }

    }
}
