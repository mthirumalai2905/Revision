
class Node{
    int val;
    Node left, right;
    int height;

    Node(int val){
        this.val = val;
        this.height = 1;
    }
}

public class AVLTree{
    private Node root;

    private int getHeight(Node node){
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(Node node){
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1; 
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1; 

        return y;
    }

    private Node insert(Node node, int key){
        if(node == null) return new Node(key);

        if(key < node.val){
            node.left = insert(node.left, key);
        } else if(key > node.val){
            node.right = insert(node.right, key);
        } else return node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if(balance > 1 && key < node.left.val){
            return rotateRight(node);
        }

        if(balance < -1 && key > node.right.val){
            return rotateLeft(node);
        }

        if(balance > 1 && key > node.left.val){
            node.left = rotateLeft(node.left);
            return rotateLeft(node);
        }

        if(balance < -1 && key < node.right.val){
            node.right = rotateRight(node.right);
            return rotateRight(node);
        }

        return node;
    }

    public void insert(int key){
        root =  insert(root, key);
    }

    public void inOrder(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node){
        if(node == null){
            inOrderTraversal(node.left);
            System.out.println(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);


        System.out.println("Inorder traversal of the constructed AVL tree is: ");
        tree.inOrder();
    }


}
