public class FenwickTree {
    int[] arr; int N;
    int[] bits;
    FenwickTree(int N) {
        this.N = N;
        this.arr = new int[N];
        this.bits = new int[N + 1];
    }
    // T(N) --> log(N)
    public void update(int idx, int elt) {
        while( idx <= N ) {
            bits[idx] += elt;
            idx += idx & (-idx);
        }
    }
    public int range(int idx) {     // sum(range(1, idx))
        int sum = 0;
        // calculate
        while( idx > 0 ) {
            sum += bits[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }
    // T(N) = O(1)
    public int rangeQuery(int i, int j) {
        return range(j) - range(i-1);
    }
    public static void main(String[] args) {
        int N = 8;
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        FenwickTree fenwickTree = new FenwickTree(N);
        for(int i=1; i <= N; i++)
            fenwickTree.update(i, arr[i-1]);

        for(int bit: fenwickTree.bits)
            System.out.print(bit + " ");
        System.out.println();
        System.out.println( fenwickTree.range(5) );             // 150
        System.out.println( fenwickTree.rangeQuery(3, 6) );     // 230 (30 + 40 + 50 + 60)
    }
}