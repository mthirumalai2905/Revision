class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int mx = 0;
        for(Node child : root.children){
            mx = Math.max(mx,maxDepth(child));
        }
        return mx + 1;
    }
}
