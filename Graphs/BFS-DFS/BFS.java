class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        visited.add(0);
        
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            
            for(int ngbr : adj.get(node)){
                if(!visited.contains(ngbr)){
                    q.offer(ngbr);
                    visited.add(ngbr);
                }
            }
        }
        
        return list;
    }
}
