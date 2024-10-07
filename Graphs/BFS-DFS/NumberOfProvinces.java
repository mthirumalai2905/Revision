class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int V = isConnected.length;
        HashSet<Integer> vis = new HashSet<>();

        for(int i = 0; i < V; i++){
            if(!vis.contains(i)){
                dfs(i, vis, isConnected);
                count++;
            }
        }

        return count;
    }
    public void dfs(int node, HashSet<Integer> vis, int[][] isConnected){
        vis.add(node);


        for(int j = 0; j < isConnected[0].length; j++){
            if(isConnected[node][j] == 1 && !vis.contains(j)){
                dfs(j, vis, isConnected);
            }
        }
    }
}
