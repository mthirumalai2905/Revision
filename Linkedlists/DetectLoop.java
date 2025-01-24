class Solution{
  public ListNode detectLoop(ListNode head){
    ListNode curr = head;
    ListNode slow = curr;
    ListNode fast = curr;


  while(fast.next != null && fast.next.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast){
      return true;
    }
  }

  return false;
  }
}
