
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        int[] topo = new int[V];
        int idx = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo[idx++] = node;
            
            for(int ngbr : adj.get(node)){
                indegree[ngbr]--;
                if(indegree[ngbr] == 0){
                    q.offer(ngbr);
                }
            }
        }
        
        return topo;
    }
}
