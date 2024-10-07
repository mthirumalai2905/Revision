class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color){
            return image;
        }
        fill(image, sr, sc, originalColor, color);
        return image;
    }
    private void fill(int[][] image, int row, int col, int originalColor, int newColor){
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor){
            return;
        }

        image[row][col] = newColor;
        fill(image, row + 1, col, originalColor, newColor);
        fill(image, row-1, col, originalColor, newColor);
        fill(image, row, col+1, originalColor, newColor);
        fill(image, row, col-1, originalColor, newColor);
    }
}
