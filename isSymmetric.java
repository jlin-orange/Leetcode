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
    Checks if subtrees of the root are mirrored using a recursive helper
    */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrored(root.left, root.right);
    }
    
    /*
    Helper function that checks if subtrees are correctly mirrored
    */
    public boolean isMirrored(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            if (left.val != right.val) return false;
            return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
        } 
        return false; // case: oneNode == null && otherNode != null        
    }
}
