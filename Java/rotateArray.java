class Solution {
    /**
    * Runtime: O(n) - time to clone array then copy correct values into array
    * Space: O(n) - space for copy of nums[]
    */
    public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i+k)%nums.length] = copy[i];
        }
    }
    
    // FLIP to rotate left: copy[i] = nums[(i+k)%nums.length];
}
