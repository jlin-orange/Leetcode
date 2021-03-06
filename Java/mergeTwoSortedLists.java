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
    /**
    * Time: O(m + n) - combined length of two lists
    * Space: O(1) - one head node
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currNode = new ListNode();
        ListNode l1Finger = l1;
        ListNode l2Finger = l2;
        
        // edge cases - empty lists
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }   
        
        if (l1.val <= l2.val) {
            currNode = l1;  
            l1Finger = l1.next;
        } else {
            currNode = l2;
            l2Finger = l2.next;
        }
        
        while (l1Finger != null && l2Finger != null) { // runs until one list is out
            if (l1Finger.val <= l2Finger.val) {
                currNode.next = l1Finger;  
                l1Finger = l1Finger.next;
            } else {
                currNode.next = l2Finger;
                l2Finger = l2Finger.next;
            }
            currNode = currNode.next;
        }
        
        if (l1Finger != null) {
            currNode.next = l1Finger; // slice the rest of the list
        } else if (l2Finger != null) {
            currNode.next = l2Finger;
        }
        
        // return the head of newly merged lists (the one with smaller head)
        if (l1.val <= l2.val) {
            return l1;
        } else {
            return l2;
        }
    }
}
