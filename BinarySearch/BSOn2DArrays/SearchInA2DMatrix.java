class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            boolean found = bs(matrix[i], target);
            if(found){
                return true;
            }
        }
        return false;
    }
    public boolean bs(int[] matrix, int target){
        int n = matrix.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid] == target){
                return true;
            }
            if(matrix[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
