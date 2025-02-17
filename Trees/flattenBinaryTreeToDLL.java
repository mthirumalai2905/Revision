class Solution {
    TreeNode head = null;
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        flatten(root.right);
    }
}
