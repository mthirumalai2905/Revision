class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]  = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    public int findFirst(int[] num, int target){
        int left = 0;
        int right = num.length - 1;
        int floor = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(num[mid] == target){
                floor = mid;
                right = mid - 1;
            }
            if(num[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return floor;
    }

    public int findLast(int[] num, int target){
        int left = 0;
        int right = num.length - 1;
        int ceil = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(num[mid] == target){
                ceil = mid;
                left = mid + 1;
            }
            if(num[mid] > target){
                 right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ceil;
    }
}
