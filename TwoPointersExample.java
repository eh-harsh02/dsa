import java.util.Arrays;
public class TwoPointersExample {
    public static boolean hasPairWithSum(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
// 1+7 = 8 == 6 false;
// l = 1, r = 6
// 1 + 6 = 7 == 6 false;
// l++ = l = 1, r = 5
// 1 + 5 = 6 == 6 true;
    public static int[] findPairSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                return new int[]{left, right};
            }else if(sum < target) {
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int arr[] = {1, 3, 5, 6, 7};  
        int target = 6;
        boolean result = hasPairWithSum(arr, target);
        System.out.println(result);
        int[] res = findPairSorted(arr, target);
        System.out.println(Arrays.toString(res));
    }
}
