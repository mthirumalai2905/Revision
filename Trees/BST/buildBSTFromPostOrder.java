class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode bstFromPostorder(int[] postorder) {
        return helper(postorder, new int[]{postorder.length - 1}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] postorder, int[] idx, int min, int max) {
        if (idx[0] < 0) {
            return null; 
        }

        int val = postorder[idx[0]];

    
        if (val < min || val > max) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        idx[0]--; 
        root.right = helper(postorder, idx, val, max); 
        root.left = helper(postorder, idx, min, val);   

        return root;
    }
}
