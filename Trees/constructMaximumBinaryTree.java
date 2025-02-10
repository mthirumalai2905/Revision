/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }
    TreeNode solve(int start, int end, int[] nums){
        if(start > end) return null;

        int maxIdx = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[maxIdx] < nums[i]){
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = solve(start, maxIdx - 1, nums);
        root.right = solve(maxIdx+1, end, nums);
        return root;
    }
}
