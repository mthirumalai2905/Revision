class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode bstFromInorder(int[] inorder) {
        return helper(inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = helper(inorder, left, mid - 1); 
        root.right = helper(inorder, mid + 1, right); 

        return root;
    }
}
