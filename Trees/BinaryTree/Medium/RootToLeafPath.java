class Solution {
   public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
            ArrayList<Integer> path = new ArrayList<>();
            solve(root, path, list);
        
        return list;
    }

    private static void solve(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> newPath = new ArrayList<>(path);
        newPath.add(root.data);

        if (root.left == null && root.right == null) {
            list.add(newPath);
        } else {
            if (root.left != null) {
                solve(root.left, newPath, list);
            }
            if (root.right != null) {
                solve(root.right, newPath, list);
            }
        }
    }
} 
