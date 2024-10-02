class Solution{
  Node head = null;
  Node prev = null;

public Node bToSLL(Node root){
  if(root == null) return null;

  bToSLL(root.left);

  if(prev == null){
    head = root;
  } else {
    prev.next = root;
  }

  prev = root;

  bToSLL(root.right);

  return head;
}
}
