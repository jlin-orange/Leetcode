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
    Travere the binary tree to find the next open child position where the target value fits
    
    Time: O(lgn)
    Space: O(1)
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            return newNode;
        }
        insertNode(root, val);
        return root;
    }
    
    public void insertNode(TreeNode curr, int targetVal) {
        int currVal = curr.val;
        
        if (targetVal > currVal) {
            if (curr.right == null) {
                TreeNode newNode = new TreeNode();
                newNode.val = targetVal;
                curr.right = newNode;
            } else {
                insertNode(curr.right, targetVal);
            }
        } else { // targetVal < currVal
            if (curr.left == null) {
                TreeNode newNode = new TreeNode();
                newNode.val = targetVal;
                curr.left = newNode;
            } else {
                insertNode(curr.left, targetVal);
            }
        }
    }
}
