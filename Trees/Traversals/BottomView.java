class Pair{
    public Node node;
    public int hd;
    
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair current = q.poll();
            Node node = current.node;
            int hd = current.hd;
            
            
                map.put(hd, node.data);
            
            
            if(node.left != null){
                q.add(new Pair(node.left, hd-1));
            }
            
            if(node.right != null){
                q.add(new Pair(node.right, hd+1));
            }
            
        }
            list.addAll(map.values());
        
        return list;
    }
}
