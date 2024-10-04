class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    public void pushLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next(){
        TreeNode nextNode = stack.pop();
        pushLeft(nextNode.right);
        return nextNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

