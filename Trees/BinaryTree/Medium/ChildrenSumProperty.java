class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null){
            return 1;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int leftSum = (root.left != null) ? root.left.data : 0;
        int rightSum = (root.right != null) ? root.right.data : 0;
        
        if(root.data == leftSum + rightSum){
            return (isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) ? 1 : 0;
        }
        
        return 0;
        
        
    }
}
