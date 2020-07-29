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
    
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) 
            targetedDFS(root, 1);
        
        return sum;
    }
    
    /*
    A modded DFS that accounts for parent direction s.t. you 
    can detect when you're at a left leaf
    
    @param curr  the present node
    @param parentDirection  the direction the parent took to visit node (0: left, 1: right) 
    */
    public void targetedDFS(TreeNode curr, int parentDirection) {
        // Check if at Leaf 
        if (curr.left == null && curr.right == null) {
            if (parentDirection == 0) // @ left leaf specifically
                sum += curr.val;
        } else {
            if (curr.left != null)
                targetedDFS(curr.left, 0);
            
            if (curr.right != null)
                targetedDFS(curr.right, 1);
        }
    }
}
