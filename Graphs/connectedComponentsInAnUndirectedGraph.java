class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adjList, visited, component);
                Collections.sort(component);
                result.add(component);
            }
        }

        return result;
    }

    private void dfs(int vertex, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, component);
            }
        }
    }
}
