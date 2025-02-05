class Solution {
    public static Node buildTreeFromPreorder(int inorder[], int preorder[]) {
        return solvePreorder(inorder, preorder, 0, inorder.length - 1, new int[]{0});
    }

    public static Node buildTreeFromPostorder(int inorder[], int postorder[]) {
        return solvePostorder(inorder, postorder, 0, inorder.length - 1, new int[]{postorder.length - 1});
    }

    private static Node solvePreorder(int[] inorder, int[] preorder, int start, int end, int[] idx) {
        if (start > end) {
            return null;
        }

        int currentVal = preorder[idx[0]++];
        Node root = new Node(currentVal);

        int i = start;
        while (i <= end && inorder[i] != currentVal) {
            i++;
        }

        root.left = solvePreorder(inorder, preorder, start, i - 1, idx);
        root.right = solvePreorder(inorder, preorder, i + 1, end, idx);

        return root;
    }

    private static Node solvePostorder(int[] inorder, int[] postorder, int start, int end, int[] idx) {
        if (start > end) {
            return null;
        }

        int currentVal = postorder[idx[0]--];
        Node root = new Node(currentVal);

        int i = start;
        while (i <= end && inorder[i] != currentVal) {
            i++;
        }

        root.right = solvePostorder(inorder, postorder, i + 1, end, idx);
        root.left = solvePostorder(inorder, postorder, start, i - 1, idx);

        return root;
    }
}
