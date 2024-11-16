class Solution {
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return solve(0, 0, m - 1, grid, n, m, dp);
    }
    
    private int solve(int row, int col1, int col2, int[][] grid, int n, int m, int[][][] dp) {
        if(row == n - 1) {
            if(col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }
        
        if(dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        
        int maxCherries = 0;
        for(int move1 = -1; move1 <= 1; move1++) {
            for(int move2 = -1; move2 <= 1; move2++) {
                int newCol1 = col1 + move1;
                int newCol2 = col2 + move2;
                
                if(newCol1 >= 0 && newCol1 < m && newCol2 >= 0 && newCol2 < m) {
                    int cherries = 0;
                    if(col1 == col2) {
                        cherries = grid[row][col1];
                    } else {
                        cherries = grid[row][col1] + grid[row][col2];
                    }
                    cherries += solve(row + 1, newCol1, newCol2, grid, n, m, dp);
                    maxCherries = Math.max(maxCherries, cherries);
                }
            }
        }
        
        return dp[row][col1][col2] = maxCherries;
    }
}
