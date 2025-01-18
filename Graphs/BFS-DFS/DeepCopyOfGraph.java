/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        q.offer(node);

        while(!q.isEmpty()){
            Node current = q.poll();

            for(Node ngbr : current.neighbors){
                if(!visited.containsKey(ngbr)){
                    Node ngbrClone = new Node(ngbr.val);
                    visited.put(ngbr, ngbrClone);
                    q.offer(ngbr);
                }
                visited.get(current).neighbors.add(visited.get(ngbr));
            }
        }

        return clone;
    }
}
