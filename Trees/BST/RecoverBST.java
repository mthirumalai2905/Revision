class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
       inorder(root);
       if(first != null && second != null){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
       }    
    }
    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        inorder(node.right);
    }
}
