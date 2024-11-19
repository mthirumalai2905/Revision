class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int size) {
        n = size;
        tree = new int[n + 1];
    }

    public void update(int idx, int value) {
        while (idx <= n) {
            tree[idx] += value;
            idx += idx & -idx;
        }
    }

    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        FenwickTree fenwickTree = new FenwickTree(arr.length);

        for (int i = 0; i < arr.length; i++) {
            fenwickTree.update(i + 1, arr[i]);
        }

        System.out.println("Sum of first 3 elements: " + fenwickTree.query(3));
        System.out.println("Sum of first 5 elements: " + fenwickTree.query(5));

        fenwickTree.update(3, 6);
        System.out.println("Sum of first 3 elements after update: " + fenwickTree.query(3));
    }
}

