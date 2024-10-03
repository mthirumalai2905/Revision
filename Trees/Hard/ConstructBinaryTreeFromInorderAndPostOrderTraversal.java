class Solution {
    public TreeNode solve(int[] inorder, int[] postorder, int start, int end, int idx) {
        if (start > end) {
            return null;
        }

        int rootval = postorder[idx];
        TreeNode root = new TreeNode(rootval);
        int i = 0;

        for (i = start; i <= end; i++) {
            if (inorder[i] == rootval) {
                break;
            }
        }

        
        root.right = solve(inorder, postorder, i + 1, end, idx - 1); 
        root.left = solve(inorder, postorder, start, i - 1, idx - (end - i + 1)); 

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return solve(inorder, postorder, 0, n - 1, n - 1);
    }
}
