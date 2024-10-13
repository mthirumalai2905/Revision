class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int ngbr : adj.get(i)){
                inDegree[ngbr]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int ngbr : adj.get(node)){
                inDegree[ngbr]--;
                if(inDegree[ngbr] == 0){
                    q.offer(ngbr);
                }
            }
        }
        
        return count != V;
    }
}
