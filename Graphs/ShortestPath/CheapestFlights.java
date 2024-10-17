import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});  
        
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int city = curr[0], cost = curr[1], stops = curr[2];
            
            if (stops > k) continue;
            
            if (graph.containsKey(city)) {
                for (int[] next : graph.get(city)) {
                    int nextCity = next[0], price = next[1];
                    if (cost + price < minCost[nextCity]) {
                        minCost[nextCity] = cost + price;
                        queue.offer(new int[]{nextCity, minCost[nextCity], stops + 1});
                    }
                }
            }
        }
        
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
