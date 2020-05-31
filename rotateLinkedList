import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        // find length of LL
        int length = 0;
        LLNode finger = node;
        LLNode endNode = null;
        LLNode newHead = null;
        
        while (finger != null) {
            length++;
            if (finger.next == null) {
                endNode = finger;
            }
            finger = finger.next;
        }
        
        if (k == length || k == 0) {
            return node;
        }
        
        finger = node; // reset finger to head
        
        for (int i = 0; i < length - (k+1); i++) { // gets its to final node before the rest is cut off
            finger = finger.next;
            newHead = finger.next;
        } 
        
        endNode.next = node;
        finger.next = null;
        
        return newHead;
    }
}
