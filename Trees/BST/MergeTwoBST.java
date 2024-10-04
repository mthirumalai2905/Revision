import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        inorder(root1, list1);
        inorder(root2, list2);
        
        List<Integer> mergedList = mergeSortedLists(list1, list2);
        
        return sortedArrayToBST(mergedList, 0, mergedList.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }
        
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }
        
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }
        
        return merged;
    }
    
    private TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        
        return node;
    }
}
