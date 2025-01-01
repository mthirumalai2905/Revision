class Solution{
    private Node prev = null;
    private Node head = null;
    
    public Node flattenToDLL(Node root){
        if(root == null) return null;
        
        flattenToDLL(root.left);
        
        
        if(prev == null){
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        
        
        flattenToDLL(root.right);
        return head;
    }
}
