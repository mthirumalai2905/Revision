class Solution {
    public int countNodes(TreeNode root) {
        return solve(root);
    }
    public int solve(TreeNode root){
        if(root == null) return 0;
        int l = solve(root.left);
        int e = solve(root.right);
        return l+e+1;
    }
}
