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
    * Time: O(n)
    * Space: O(1)
    */
    public ListNode middleNode(ListNode head) {
        int nodeLength = 1;
        ListNode finger = head;
        while (finger.next != null) { // determine length of linked list - O(n)
            finger = finger.next;
            nodeLength++;
        }
        
        finger = head; // reset finger to head of list
        int middle = (nodeLength/2);
        
        for (int i = 0; i < middle; i++) { // iterate through linked list to get to middle node - O(n/2)
            finger = finger.next;
        }
        
        return finger;
    }
}
