
class Solution {
    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        int[][] memo = new int[n+1][W+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(W, n, wt, val, memo, 0);
    }

    static int solve(int W, int n, int[] wt, int[] val, int[][] memo, int idx) {
        if (idx >= n || W == 0) {
            return 0;
        }

        if (memo[idx][W] != -1) {
            return memo[idx][W];
        }

        if (wt[idx] > W) {
            return memo[idx][W] = solve(W, n, wt, val, memo, idx + 1);
        }

        int take = val[idx] + solve(W - wt[idx], n, wt, val, memo, idx + 1);
        int notTake = solve(W, n, wt, val, memo, idx + 1);

        return memo[idx][W] = Math.max(take, notTake);
    }
}
