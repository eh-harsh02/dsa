import java.util.*;
public class multiplesOf3 {
    static class SegmentTree {
        int[] count0, count1, count2, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            count0 = new int[4 * n];
            count1 = new int[4 * n];
            count2 = new int[4 * n];
            lazy = new int[4 * n];
            build(0, n - 1, 1);
        }

        void build(int l, int r, int node) {
            if (l == r) {
                count0[node] = 1;
                return;
            }
            int mid = (l + r) / 2;
            build(l, mid, 2 * node);
            build(mid + 1, r, 2 * node + 1);
            count0[node] = count0[2 * node] + count0[2 * node + 1];
        }

        void push(int node, int l, int r) {
            int times = lazy[node] % 3;
            if (times != 0) {
                for (int i = 0; i < times; i++) {
                    int temp = count2[node];
                    count2[node] = count1[node];
                    count1[node] = count0[node];
                    count0[node] = temp;
                }
                if (l != r) {
                    lazy[2 * node] += times;
                    lazy[2 * node + 1] += times;
                }
                lazy[node] = 0;
            }
        }

        void updateRange(int left, int right) {
            updateRange(0, n - 1, 1, left, right);
        }

        void updateRange(int l, int r, int node, int ql, int qr) {
            push(node, l, r);
            if (r < ql || l > qr) return; // no overlap
            if (ql <= l && r <= qr) { // total overlap
                lazy[node]++;
                push(node, l, r);
                return;
            }
            // partial overlap
            int mid = (l + r) / 2;
            updateRange(l, mid, 2 * node, ql, qr);
            updateRange(mid + 1, r, 2 * node + 1, ql, qr);
            count0[node] = count0[2 * node] + count0[2 * node + 1];
            count1[node] = count1[2 * node] + count1[2 * node + 1];
            count2[node] = count2[2 * node] + count2[2 * node + 1];
        }

        int query(int left, int right) {
            return query(0, n - 1, 1, left, right);
        }

        int query(int l, int r, int node, int ql, int qr) {
            push(node, l, r);
            if (r < ql || l > qr) return 0; // no overlap
            if (ql <= l && r <= qr) return count0[node]; // total overlap
            int mid = (l + r) / 2;
            return query(l, mid, 2 * node, ql, qr) + query(mid + 1, r, 2 * node + 1, ql, qr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt(); 

        SegmentTree st = new SegmentTree(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (type == 0) {
                st.updateRange(A, B);
            } else {
                sb.append(st.query(A, B)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
