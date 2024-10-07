class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        dfs(0, list, visited, adj);
        return list;
    }
    public void dfs(int node, ArrayList<Integer> list, HashSet<Integer> visited, ArrayList<ArrayList<Integer>> adj){
        list.add(node);
        visited.add(node);
        
        for(int ngbr : adj.get(node)){
            if(!visited.contains(ngbr)){
                dfs(ngbr, list, visited, adj);
            }
        }
    }
}
