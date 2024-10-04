class Solution {
    Node reverse(Node head) {
        if (head == null || head.next == head) {
            return head; 
        }

        Node prev = null;
        Node curr = head;
        Node tail = head;

        do {
            Node nextNode = curr.next;
            curr.next = prev; 
            prev = curr;      
            curr = nextNode; 
        } while (curr != head); 

        tail.next = prev; 

        return prev;
    }

    Node deleteNode(Node head, int key) {
        if (head == null) return null; 

        Node curr = head;
        Node prev = null;
        Node tail = head;

        while (tail.next != head) {
            tail = tail.next;
        }

        if (curr.data == key) {
            if (head == tail) { 
                return null;       
                }
            head = head.next; 
            tail.next = head; 
            return head; 
        }

        do {
            if (curr.next.data == key) {
                curr.next = curr.next.next; 
                return head; 
            }
            curr = curr.next; 
        } while (curr != head); 

        return head; 
    }
}
