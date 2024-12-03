/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            list.add(curr.val);

            if(curr.left != null){
                s.push(curr.left);
            }

            if(curr.right != null){
                s.push(curr.right);
            }
        }

        Collections.reverse(list);
        return list;
    }
}
