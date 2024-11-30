class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Create a list to store all edges
        List<int[]> edges = new ArrayList<>();
        
        // Collect all edges from the adjacency list
        for (int i = 0; i < V; i++) {
            for (int[] edge : adj.get(i)) {
                // Create edge with format [source, destination, weight]
                edges.add(new int[]{i, edge[0], edge[1]});
            }
        }
        
        // Sort edges by weight
        edges.sort(Comparator.comparingInt(a -> a[2]));
        
        // Initialize disjoint set data structure
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        
        int mstWeight = 0;
        int edgeCount = 0;
        
        // Process edges
        for (int[] edge : edges) {
            // Stop when we have V-1 edges (complete MST)
            if (edgeCount == V - 1) break;
            
            int u = edge[0], v = edge[1], weight = edge[2];
            
            // Check if including this edge creates a cycle
            if (findParent(u, parent) != findParent(v, parent)) {
                // Add edge to MST
                union(u, v, parent, rank);
                mstWeight += weight;
                edgeCount++;
            }
        }
        
        return mstWeight;
    }
    
    // Find parent with path compression
    static int findParent(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }
    
    // Union by rank
    static void union(int u, int v, int[] parent, int[] rank) {
        int rootU = findParent(u, parent);
        int rootV = findParent(v, parent);
        
        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}
