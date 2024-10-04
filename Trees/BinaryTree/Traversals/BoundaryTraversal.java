import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (isLeaf(node)) {
            result.add(node.val);
            return;  
        }
        if (node.left != null) {
            addLeaves(node.left, result);
        }
        if (node.right != null) {
            addLeaves(node.right, result);
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        TreeNode curr = node.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }

    ArrayList<Integer> boundary(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return new ArrayList<>(); 
        }
        if (!isLeaf(node)) {
            result.add(node.val);
        }
        addLeftBoundary(node, result);
        addLeaves(node, result);
        addRightBoundary(node, result);
        return new ArrayList<>(result);  
    }
}
