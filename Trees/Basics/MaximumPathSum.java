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
    public static int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        int one = l + r + root.val;
        int two = Math.max(l,r) + root.val;
        int three = root.val;

        maxSum = Math.max(maxSum, Math.max(one, Math.max(two, three)));

        return Math.max(two, three);
    }
}
