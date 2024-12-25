import java.util.Arrays;

class Main {
    public static int[] BellmanFord(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) { // Iterate exactly V-1 times
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                        if (dist[u] + graph[u][v] < dist[v]) {
                            dist[v] = dist[u] + graph[u][v];
                        }
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 4, 0, 0, 0},
            {0, 0, 4, 2, 7, 0},
            {0, 0, 0, 3, 4, 0},
            {0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0}
        };
        int src = 0;
        int[] distances = BellmanFord(graph, src);

        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from source to vertex " + i + " is " + distances[i]);
        }
    }
}

