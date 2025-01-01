import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    private void dfs(int[][] graph, int currentNode, List<Integer> path, List<List<Integer>> result) {
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[currentNode]) {
            path.add(neighbor); 
            dfs(graph, neighbor, path, result);
            path.remove(path.size() - 1); 
        }
    }
}
