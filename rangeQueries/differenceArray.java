// LeetCode - 370 (Range  Addition)

class Solution {
   public int[] getModifiedArray(int n, int[][] updates){
       int[] diff = new int[n];
       
       for(int[] u : updates){
           int start = u[0];
           int end = u[1];
           int inc = u[2];
           
           diff[start] += inc;
           if(end + 1 < n){
               diff[end + 1] -= inc;
           }
       }
       
       //Computing the final prefix sum of the array 
       int[] result = new int[n];
       result[0] = diff[0];
       for(int i = 1; i < n; i++){
           result[i] = result[i-1] + diff[i];
       }
       return result;
   }
}
