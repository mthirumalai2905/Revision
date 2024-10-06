class Solution {
    int median(int matrix[][], int R, int C) {
        int[] arr = new int[R * C];
        int index = 0;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        
        Arrays.sort(arr);
        return arr[(R * C) / 2];
    }
}
