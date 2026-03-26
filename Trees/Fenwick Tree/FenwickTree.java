public class FenwickTree {
    
    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void build(int[] arr) {
            for (int i = 0; i < n; i++) {
                update(i, arr[i]);
            }
        }

        void update(int i, int val) {
            i = i + 1;
            while (i <= n) {
                tree[i] += val;
                i += (i & -i);
            }
        }

        int sum(int i) {
            i = i + 1;
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= (i & -i);
            }
            return res;
        }

        int rangeSum(int l, int r) {
            return sum(r) - sum(l - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 }; // 0-based

        Fenwick ft = new Fenwick(arr.length);
        ft.build(arr);

        System.out.println(ft.sum(3)); // 1+2+3+4 = 10
        System.out.println(ft.rangeSum(1, 3)); // 2+3+4 = 9

        ft.update(2, 3); // index 2 → +3

        System.out.println(ft.sum(3)); // 13
    }
}