import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the graph with prerequisites
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }
        
        // Create a 2D array to store reachability
        boolean[][] reachable = new boolean[numCourses][numCourses];
        
        // Perform DFS for each course to find all reachable courses
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            dfs(graph, i, visited, reachable);
        }
        
        // Prepare the result for the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }
        
        return result;
    }
    
    private void dfs(List<List<Integer>> graph, int course, boolean[] visited, boolean[][] reachable) {
        visited[course] = true;
        for (int nextCourse : graph.get(course)) {
            if (!visited[nextCourse]) {
                reachable[course][nextCourse] = true; // course is a prerequisite of nextCourse
                dfs(graph, nextCourse, visited, reachable);
            }
            // Mark reachable for all courses that can be reached from nextCourse
            for (int j = 0; j < reachable.length; j++) {
                if (reachable[nextCourse][j]) {
                    reachable[course][j] = true;
                }
            }
        }
    }
}
