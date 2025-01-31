import java.util.*;

class Solution {
    private int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        int index = 2;
        Map<Integer, Integer> areaMap = new HashMap<>();
        areaMap.put(0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areaMap.put(index, dfs(grid, i, j, index));
                    index++;
                }
            }
        }

        int maxArea = areaMap.values().stream().max(Integer::compareTo).orElse(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxArea = Math.max(maxArea, calculatePotentialArea(grid, i, j, areaMap));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int area = 1;
        area += dfs(grid, i + 1, j, index);
        area += dfs(grid, i - 1, j, index);
        area += dfs(grid, i, j + 1, index);
        area += dfs(grid, i, j - 1, index);
        return area;
    }

    private int calculatePotentialArea(int[][] grid, int i, int j, Map<Integer, Integer> areaMap) {
        Set<Integer> seenComponents = new HashSet<>();
        int potentialArea = 1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                int componentIndex = grid[ni][nj];
                if (componentIndex > 1 && seenComponents.add(componentIndex)) {
                    potentialArea += areaMap.get(componentIndex);
                }
            }
        }

        return potentialArea;
    }
}
