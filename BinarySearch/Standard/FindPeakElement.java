class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + right >> 1;

            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
