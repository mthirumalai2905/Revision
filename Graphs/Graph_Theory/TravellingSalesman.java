// Brute Force
import java.util.*;

public class TravelingSalesman {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true; 

        int minCost = tsp(graph, visited, 0, n, 1, 0);
        System.out.println("Minimum cost of TSP: " + minCost);
    }

    static int tsp(int[][] graph, boolean[] visited, int currCity, int n, int count, int cost) {
        if (count == n) {
            return cost + graph[currCity][0];
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[currCity][i] > 0) {
                visited[i] = true;
                int newCost = tsp(graph, visited, i, n, count + 1, cost + graph[currCity][i]);
                minCost = Math.min(minCost, newCost);
                visited[i] = false;
            }
        }
        return minCost;
    }
}

// Held-Karp
import java.util.Arrays;

public class TravelingSalesmanHeldKarp {
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int n = graph.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, INF); 
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue; 

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0 || graph[u][v] == 0) continue; 
                    int newMask = mask | (1 << v);
                    dp[newMask][v] = Math.min(dp[newMask][v], dp[mask][u] + graph[u][v]);
                }
            }
        }

        int minCost = INF;
        for (int u = 1; u < n; u++) {
            if (graph[u][0] > 0) {
                minCost = Math.min(minCost, dp[(1 << n) - 1][u] + graph[u][0]);
            }
        }

        System.out.println("Minimum cost of TSP: " + minCost);
    }
}

