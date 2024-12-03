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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       Stack<TreeNode> s = new Stack<>();
       TreeNode curr = root;
       while(curr != null || !s.isEmpty()){
        while(curr != null){
            s.push(curr);
            curr = curr.left;
        }

        curr = s.pop();
        list.add(curr.val);
        curr = curr.right;
       }

       return list;
    }
}
