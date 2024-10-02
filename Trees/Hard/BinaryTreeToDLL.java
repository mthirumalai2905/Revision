

//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    Node prev = null;
    Node head = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here
	if(root == null) return null;
	bToDLL(root.left);
	if(prev == null) head = root;
	else{
	    root.left = prev;
	    prev.right = root;
	}
	prev = root;
	bToDLL(root.right);
	return head;
	
    }
}
