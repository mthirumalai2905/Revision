class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        
        return false;
    }
    public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        
        for(int ngbr : adj.get(node)){
            if(!visited[ngbr]){
                if(dfs(ngbr, node, visited, adj)){
                    return true;
                }
            } else if(ngbr != parent){
                return true;
            }
        }
        return false;
    }
}
