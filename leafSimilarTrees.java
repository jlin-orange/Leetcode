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
    Use DFS to traverse both trees, storing all leaves in a respective arraylist.
    Afterwards, check the arraylists for equality and return the result.
    
    Time: O(n) , Space: O(n) - Linear for both 
    */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList rootOneLeaves = new ArrayList<>();
        ArrayList rootTwoLeaves = new ArrayList<>();
        
        dfs(root1, rootOneLeaves);
        dfs(root2, rootTwoLeaves);
        
        // Process of checking equality...
        // 1) Is the same list object?
        // 2) Is a list type?
        // 3) Same elements/size?
        return rootOneLeaves.equals(rootTwoLeaves);
    }
    
    public void dfs(TreeNode root, ArrayList leafList) {
        if (root == null) {
            return;
        }
 
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
            return;
        }
        
        dfs(root.left, leafList);
        dfs(root.right, leafList);
    }
    
}
