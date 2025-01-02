class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
       if(arr == null || arr.length == 0 || k <= 0 || k > arr.length){
           return 0;
       }
       
       int mx = Integer.MIN_VALUE;
       int curr = 0;

        for(int i = 0; i < k; i++){
            curr += arr[i];
        }
        mx = curr;
        
        for(int i = k; i < arr.length; i++){
            curr -= arr[i-k];
            curr += arr[i];
            mx = Math.max(curr,mx);
        }
        
        return mx;
    }
}
