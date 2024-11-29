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
