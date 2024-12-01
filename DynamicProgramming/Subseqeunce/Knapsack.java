class Solution{
    public int knapsack(int[] weights, int[] values, int n, int W){
        Integer[][] dp = new Integer[n][W+1];
        return solve(dp,weights,values,W,0);
    }
    public static int solve(Integer[][] dp, int[] weights, int[] values, int remainingWeight, int idx){
        if(idx >= weights.length || remainingWeight == 0){
            return  0;
        }

        if(dp[idx][remainingWeight] != null){
            return dp[idx][remainingWeight];
        }

        int take = 0;
        if(weights[idx] <= remainingWeight){
            take = values[idx] + solve(dp, weights, values, remainingWeight - weights[idx], idx + 1)
        }

        int notTake = solve(dp, weights, values, remainingWeight, idx + 1);

        return dp[idx][remaingingWeight] = Math.max(take, notTake);
    }
}
        
