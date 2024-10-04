class Solution {
    public static void createTree(Node root0, ArrayList<Integer> v) {
        if (v == null || v.size() == 0) {
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root0);
        
        int i = 1;
        
        while (i < v.size() && !q.isEmpty()) {
            Node current = q.poll();
            
            if (i < v.size()) {
                current.left = new Node(v.get(i));
                q.offer(current.left);
                i++;
            }
            
            if (i < v.size()) {
                current.right = new Node(v.get(i));
                q.offer(current.right);
                i++;
            }
        }
    }
}
