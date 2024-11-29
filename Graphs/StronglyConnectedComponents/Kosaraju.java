import java.util.*;

class Solution {
    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[v] = true;
        
        for (int u : adj.get(v)) {
            if (!vis[u]) {
                dfs(u, adj, vis, stack);
            }
        }
        
        stack.push(v);
    }

    private void dfstwo(int v, ArrayList<ArrayList<Integer>> rev, boolean[] vis, List<Integer> currentSCC) {
        vis[v] = true;
        
        currentSCC.add(v);
        
        for (int u : rev.get(v)) {
            if (!vis[u]) {
                dfstwo(u, rev, vis, currentSCC);
            }
        }
    }

    public List<List<Integer>> kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }
        
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                rev.get(v).add(u); 
            }
        }
        
        Arrays.fill(vis, false);
        List<List<Integer>> sccList = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!vis[v]) {
                List<Integer> currentSCC = new ArrayList<>();
                dfstwo(v, rev, vis, currentSCC);  
                sccList.add(currentSCC);  
            }
        }
        
        return sccList;  
    }
}
