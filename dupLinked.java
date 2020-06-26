/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            delDups(head.next, head);
        } 
        return head;
    }
    
    public void delDups(ListNode curr, ListNode prev) {
        if (curr == null) {
            return;
        } else if (curr.val == prev.val) { // keep previous node when duplicate found 
            prev.next = curr.next;
            delDups(curr.next, prev); 
        } else { // move along as normal
            delDups(curr.next, curr);
        }
    }
}



