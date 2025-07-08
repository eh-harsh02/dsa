import java.util.Scanner;
public class maxSumOfSubarray {

    public static int Sum(int[] arr, int w){
        int curr=0;
        int n = arr.length;
        for(int i=0; i<w; i++){
            curr+=arr[i];
        }
        int max=curr;
        for(int i=1; i<n-w; i++){
            curr = curr-arr[i-1]+arr[i+w-1];
            if(curr>max) max = curr;
        }
        return max;
    }


    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();   
        }
        maxSumOfSubarray obj = new maxSumOfSubarray();
        int res = obj.Sum(arr, 4);
        System.out.println(res);
    }
}




