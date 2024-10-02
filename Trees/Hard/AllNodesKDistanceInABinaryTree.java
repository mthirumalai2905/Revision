/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        buildGraph(adj, root, -1);

        return bfs(adj, target.val, k);
    }

    public static void buildGraph(HashMap<Integer, ArrayList<Integer>> map, TreeNode curr, int parent) {
        if (curr == null) return;

        map.putIfAbsent(curr.val, new ArrayList<>());

        if (parent != -1) {
            map.get(parent).add(curr.val);
            map.get(curr.val).add(parent);
        }
            buildGraph(map, curr.left, curr.val);
            buildGraph(map, curr.right, curr.val);
       
    }

    public static List<Integer> bfs(HashMap<Integer, ArrayList<Integer>> map, int target, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int level = 0;

        while (!q.isEmpty()) {
            if (level == k) {
                list.addAll(q);
                return list;  
            }

            int n = q.size();
            for (int i = 0; i < n; i++) {
                int temp = q.poll();

                for (int ngbr : map.get(temp)) {
                    if (!visited.contains(ngbr)) {
                        q.offer(ngbr);
                        visited.add(ngbr);
                    }
                }
            }
            level++;  
        }

        return list;
    }
}
