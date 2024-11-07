class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // Create a memoization table initialized to null
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        
        return isMatchHelper(s, p, m, n, dp);
    }

    private boolean isMatchHelper(String s, String p, int m, int n, Boolean[][] dp) {
        // Base case: if both pattern and string are empty
        if (n == 0) {
            return m == 0;
        }

        // If the result is already computed, return it
        if (dp[m][n] != null) {
            return dp[m][n];
        }

        boolean match = false;

        // Case 1: If the current characters match or there's a '?' in the pattern
        if (m > 0 && (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?')) {
            match = isMatchHelper(s, p, m - 1, n - 1, dp);
        }
        // Case 2: If the current character in pattern is '*', we have two options
        else if (p.charAt(n - 1) == '*') {
            // 1. Treat '*' as matching no characters (move pattern pointer)
            match = isMatchHelper(s, p, m, n - 1, dp);
            // 2. Treat '*' as matching one or more characters (move string pointer)
            if (!match && m > 0) {
                match = isMatchHelper(s, p, m - 1, n, dp);
            }
        }

        // Store the result in the dp table and return
        dp[m][n] = match;
        return match;
    }
}
