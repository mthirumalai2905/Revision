import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversal(root, nums);
        
        int left = 0;
        int right = nums.size() - 1;
        
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nums);
        nums.add(node.val);
        inorderTraversal(node.right, nums);
    }
}
