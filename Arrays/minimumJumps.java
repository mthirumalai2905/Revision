class Solution {
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        
        if(arr[0] == 0){
            return -1;
        }
        
        if(arr.length <= 1){
            return 0;
        }
        
        int maxR = 0;
        int maxS = 0;
        int j = 0;
        
        
        for(int i = 0; i < n; i++){
            maxR = Math.max(maxR, i + arr[i]);
            
            if(i == maxS){
                j++;
                maxS = maxR;
                
                
                if(maxS >= n-1){
                    return j;
                }
            }
        }
        
        return -1;
    }
}
