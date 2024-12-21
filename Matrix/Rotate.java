class Solution {
    static void rotateby90(int mat[][]) {
        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[left][j];
                mat[left][j] = mat[right][j];
                mat[right][j] = temp;
                left++;
                right--;
            }
        }
    }
}
