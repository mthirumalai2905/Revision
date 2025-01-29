import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class NaryTreeDiameter {
    private int maxDiameter = 0;

    public int diameter(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int maxHeight1 = 0, maxHeight2 = 0;

        for (TreeNode child : node.children) {
            int childHeight = dfs(child);

            if (childHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = childHeight;
            } else if (childHeight > maxHeight2) {
                maxHeight2 = childHeight;
            }
        }

        maxDiameter = Math.max(maxDiameter, maxHeight1 + maxHeight2);
        return maxHeight1 + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        node2.children.add(node5);
        node2.children.add(node6);

        NaryTreeDiameter tree = new NaryTreeDiameter();
        System.out.println("Diameter of the N-ary Tree: " + tree.diameter(root));
    }
}
