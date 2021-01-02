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
    We want to prune subtrees that DO NOT contain a 1
    
    Pruning Conditions:
    1. The parent of the subtree is 0 
    2. Neither child subtree (to the Left/Right) contains a 1
    
    How do you prune a node?
    - The parent in the tree sets their child to null
    - We do prune recursively through this main function
    }
    */
    public TreeNode pruneTree(TreeNode root) {
        if (!containsOne(root)) { // prune!
            return null;
        } 
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
     
        return root; // return yourself if you have 1 as a descendant 
    }
    
    /*
    A helper function that recursively checks if a subtree contains a '1' as its descendant. 
    */
    public boolean containsOne(TreeNode subTreeHead) {
        if (subTreeHead == null) {
            return false;
        } else if (subTreeHead.val == 1) {
            return true;
        } else { // subTreeHead.val = 0, we recurse to check all descendants
            return containsOne(subTreeHead.left) || containsOne(subTreeHead.right);
        }
    }
}
