import java.util.Arrays;

class Solution {
    public int aggressiveCows(int[] stalls, int n) {
        Arrays.sort(stalls);
        
        int left = 1; 
        int right = stalls[stalls.length - 1] - stalls[0]; 
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            
            if (canPlaceCows(stalls, n, mid)) {
                result = mid; 
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canPlaceCows(int[] stalls, int n, int distance) {
        int count = 1; 
        int lastPlaced = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= distance) {
                count++; 
                lastPlaced = stalls[i];
            }
            if (count == n) {
                return true; 
            }
        }
        
        return false; // Not enough stalls for this distance
    }
}
