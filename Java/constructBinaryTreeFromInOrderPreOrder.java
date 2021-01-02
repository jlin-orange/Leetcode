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
    A tricky problem! Uses global variables for sake of highlighting other helper function parameters
    
    Goal: reconstruct a binary tree given nodes in preorder/inorder traversal
    
    Plan of Attack:
    - recursively find the root for each node from the Preorder array
    - find the roots index in the inorder array to find how many children it has on its L/R side
    */
    int[] inorder; int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder; this.inorder = inorder;
        
        int treeSize = inorder.length - 1;
        
        return addNextNode(0, 0, treeSize);
    }
    
    private TreeNode addNextNode(int preRootIndex, int inLeftBound, int inRightBound) {
        // Edges cases (already found all children of parent node)
        if (inLeftBound > inRightBound || preRootIndex >= preorder.length) {
            return null;
        }
        
        TreeNode root = new TreeNode();
        root.val = preorder[preRootIndex];
        
        // Find index of the current root node (from preorder) in the Inorder Array
        // - Tells us the # of left children! 
        int inIndex = 0;
        for (int i = inLeftBound; i <= inRightBound; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        int nodesOnLeft = inIndex - inLeftBound;
        
        // Reminder: Preorder = Me, Left, Right
        // Ex: preorder = [3,9,20,15,7]
        //      inorder = [9,3,__,__,__]
        // Root.val = 3, nodesOnLeft = 1
        // leftChild = 0 + 1, rightChild = 0 + 1 + 1
        int leftChild = preRootIndex + 1;
        int rightChild = preRootIndex + nodesOnLeft + 1; 
        
        
        root.left = addNextNode(leftChild, inLeftBound, inIndex - 1);
        root.right = addNextNode(rightChild, inIndex + 1, inRightBound);
            
        return root;
    }
}
