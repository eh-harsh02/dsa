import java.util.Arrays;
import java.util.Scanner;
public class prefxSum {
    public static int getSubarraySum(int[] prefix, int l, int r) {
        if(l == 0) return prefix[r];
        return prefix[r] - prefix[l - 1];
    }

    public static int[] prefixSum(int[] arr){
        int n = arr.length;
        int[] prefixSumm = new int[n];
        prefixSumm[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefixSumm[i] = prefixSumm[i - 1] + arr[i];
        }
        return prefixSumm;
    }
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] prefix = prefixSum(arr);
        System.out.println(Arrays.toString(prefix));
        System.out.println(getSubarraySum(prefix, 2,3));
    }
}
