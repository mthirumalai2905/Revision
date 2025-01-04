class Solution {
    public boolean xorGame(int[] nums) {
     return nums.length % 2 == 0 || xor(nums) == 0;   
    }
    public int xor(int[] nums){
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
