class Solution {
  public Node inorderSuccessor(Node root, Node x) {
        if (x.right != null) {
            return getMin(x.right); 
        }

        Node successor = null;
        while (root != null) {
            if (x.data < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor; 
    }

    
    public Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node; 
    }
}
