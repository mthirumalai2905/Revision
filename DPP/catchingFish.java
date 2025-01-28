import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int m, n;
    private int[][] grid, vis;
    private final int[] row = {-1, 0, 0, 1};
    private final int[] col = {0, 1, -1, 0};

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.vis = new int[m][n];
        int mx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && vis[i][j] == 0) {
                    mx = Math.max(mx, bfs(i, j));
                }
            }
        }

        return mx;
    }

    private int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = 1;
        int sum = grid[i][j];

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + row[k];
                int nc = c + col[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] > 0) {
                    vis[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                    sum += grid[nr][nc];
                }
            }
        }

        return sum;
    }
}
