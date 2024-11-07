class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }

        return solve(s1, s2, m, n, 0, 0, t);
    }

    public static int solve(String s1, String s2, int m, int n, int i, int j, int[][] t) {
        if (i == m) {
            return n - j;
        } else if (j == n) {
            return m - i;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            t[i][j] = solve(s1, s2, m, n, i + 1, j + 1, t);
        } else {
            int insert = solve(s1, s2, m, n, i, j + 1, t);
            int delete = solve(s1, s2, m, n, i + 1, j, t);
            int replace = solve(s1, s2, m, n, i + 1, j + 1, t);
            t[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }

        return t[i][j];
    }
}
