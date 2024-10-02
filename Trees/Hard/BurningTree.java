class Solution {
    public static int minTime(Node root, int target) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        buildGraph(adj, -1, root);

        return bfs(adj, target);
    }

    private static void buildGraph(HashMap<Integer, List<Integer>> adj, int parent, Node curr) {
        if (curr == null) return;
        
        adj.putIfAbsent(curr.data, new ArrayList<>());
        
        if (parent != -1) {
            adj.get(curr.data).add(parent);
            adj.get(parent).add(curr.data);
        }

        buildGraph(adj, curr.data, curr.left);
        buildGraph(adj, curr.data, curr.right);
    }

    private static int bfs(HashMap<Integer, List<Integer>> adj, int start) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int minutes = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();

            while (n-- > 0) {
                int curr = queue.poll();

                for (int neighbor : adj.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return minutes;
    }

}
