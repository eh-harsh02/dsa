public class twoSum {
    public static boolean checkTwoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) return true;
            if(sum < target) left++;
            else right--;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {5, 7, 9, 12};
        int target = 15;
        boolean res = checkTwoSum(arr,target);
        System.out.println(res);
    }
}
