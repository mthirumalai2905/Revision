class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int maxCount = 0;
        int rowIdx = -1;
        
        for(int i = 0; i < arr.length; i++){
            int currentCount = countOnes(arr[i]);
            if(currentCount > maxCount){
                maxCount = currentCount;
                rowIdx = i;
            }
        }
        
        return rowIdx;
    }
    public int countOnes(int[] arr){
       int n = arr.length;
       int low = 0;
       int high = n - 1;
       while(low <= high){
           int mid = low + (high - low)/2;
           if(arr[mid] == 1){
               high = mid - 1;
           } else {
               low = mid + 1;
           }
       }
       return n - low;
    }
}
