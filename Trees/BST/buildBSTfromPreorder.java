class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder, int[] idx, int min, int max){
        if(idx[0] == preorder.length){
            return null;
        }

        int val = preorder[idx[0]];

        if(val < min || val > max){
            return null;
        }

        TreeNode root = new TreeNode(val);
        idx[0]++;

        root.left = helper(preorder, idx, min, val);
        root.right = helper(preorder, idx, val, max);
        return root;
    }
}
