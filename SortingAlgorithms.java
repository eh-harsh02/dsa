import java.util.Arrays;

public class SortingAlgorithms {
public void radixSort(int[] arr){
    for(int i = 0; i< ; i+=10){
        countingSort(arr, i);
    }
}

    public int[] countingSort(int[] arr){
        int N = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        int[] solution = new int[N];

        for(int i=0; i<N; i++){
            count[arr[i]] = ++count[arr[i]];
        }
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = N-1; i>=0; i--){
            int idx = --count[arr[i]];
            solution[idx] = arr[i];
        }
        return solution;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] solution = new int[arr.length];
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        solution = sortingAlgorithms.countingSort(arr);
        for(int elt : solution){
            System.out.print(elt + " ");
        }
    }
}
