class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        
        for(Node n : arr){
            if(n != null){
            pq.offer(n);
            }
        }
        
        Node dummy = new Node(0);
        Node curr = dummy;
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            curr.next = node;
            curr = node;
            
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
