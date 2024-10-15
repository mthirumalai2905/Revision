class Solution
{
    static class Node{
        int vertex;
        int weight;
        
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Node(S, 0));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.vertex;
            
            for(ArrayList<Integer> ngbr : adj.get(u)){
                int v = ngbr.get(0);
                int weight = ngbr.get(1);
                
                if(dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        
        return dist;
    }
}
