import java.util.HashSet;
import java.util.Scanner;
public class HashSetExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> st = new HashSet<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        st.add(7);
        for(int ar : arr){
            st.add(ar);
        }
        System.out.println(st.isEmpty());
        System.out.println(st.contains(5));
        System.out.println(st.size());
        System.out.println(st);
    }
}
