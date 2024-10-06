class Solution {
    static int findFloor(long arr[], int n, long x) {
        int floor = -1;
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] <= x){
                floor = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return floor;
    }
}
