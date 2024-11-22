import java.util.Arrays;

public class TSP {

    public static int heldKarp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dp[1][0] = 0;
        
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    
                    dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + graph[u][v]);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[(1 << n) - 1][i] + graph[i][0]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20, 25},
            {10, 0, 35, 25, 30},
            {15, 35, 0, 30, 5},
            {20, 25, 30, 0, 15},
            {25, 30, 5, 15, 0}
        };

        System.out.println("Minimum cost of traveling through all cities: " + heldKarp(graph));
    }
}

