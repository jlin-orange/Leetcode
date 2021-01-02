/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    DFS on both nodes summing when possible. Otherwise, return the remainder of a single branch
    
    Time: O(n) every node , Space: O(n) for skewed tree, logn for an average tree, 
    */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode headNode;
        
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            headNode = t1;
            t1.val += t2.val;
            headNode.left = mergeTrees(t1.left, t2.left);
            headNode.right = mergeTrees(t1.right, t2.right);
            
        } else if (t1 == null && t2 != null) { 
            return t2;
        } else { // t1 != null && t2 == null
            return t1;
        }
        return headNode;
    }
}
