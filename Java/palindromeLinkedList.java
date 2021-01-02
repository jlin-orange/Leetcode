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
    /*
    Time: O(n) , Space: O(n) 
    */
    public boolean isPalindrome(ListNode head) {
        int len = 0; // counter variables for length of linked list
        int mid;
        
        Stack<Integer> s = new Stack<>();
        
        ListNode finger = head;
        // Calculate length of the linked list
        while (finger != null) {
            len++;
            finger = finger.next;
        }
        
        if (len <= 1) {
            return true;
        }
        
        boolean odd = false;
        
        if (len % 2 == 1) { // Odd Case
            mid = len/2;
            odd = true;
        } else {  // Even Case
            mid = (len/2)-1; // Gives us the middle-left index
        }
        
        // pops first half of linked list onto a stack for comparison with the other half
        finger = head;
        for (int i = 0; i <= mid; i++) {
            s.push(finger.val);
            finger = finger.next; 
        }
        
        // pop off the mid element if the length is odd (since there's no counterpart to the middle element)
        if (odd) {
            s.pop();
            for (int i = 0; i < mid; i++) { // compare each element on stack against it's "palindromic index"
                if (s.pop() != finger.val) {
                    return false;
                }
                finger = finger.next; 
            }
        } else {
            for (int i = 0; i <= mid; i++) {
                if (s.pop() != finger.val) {
                    return false;
                }
                finger = finger.next; 
            }
        }
        
        return true;
    }
}
