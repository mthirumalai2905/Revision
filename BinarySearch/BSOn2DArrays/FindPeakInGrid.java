class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isPeak(mat,i,j,m,n)){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }
    public boolean isPeak(int[][] mat, int i, int j, int m, int n){
        if(i > 0 && mat[i][j] <= mat[i-1][j]){
            return false;
        }
        if(i < m-1 && mat[i][j] <= mat[i+1][j]){
            return false;
        }
        if(j > 0 && mat[i][j] <= mat[i][j-1]){
            return false;
        }
        if(j < n-1 && mat[i][j] <= mat[i][j+1]){
            return false;
        }
        return true;
    }
}
