class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder, new int[]{0}, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int[] preIndex, int postStart, int postEnd) {
        if (preIndex[0] >= preorder.length || postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex[0]++]);

        if (postStart == postEnd) return root;  

        int leftChildIndex = postStart;
        while (postorder[leftChildIndex] != preorder[preIndex[0]]) {
            leftChildIndex++;
        }

        root.left = buildTree(preorder, postorder, preIndex, postStart, leftChildIndex);
        root.right = buildTree(preorder, postorder, preIndex, leftChildIndex + 1, postEnd - 1);

        return root;
    }
}
