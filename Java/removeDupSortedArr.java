class Solution {
    /* 
     * Time: O(n) - 1 iteration thru the list | Space: O(1) - a few local variables
     * Runtime: 0 ms, 100% faster | Mem Usage: 41.3 mb, 62.94% less
     */
    public int removeDuplicates(int[] nums) {
        // empty list [edge case]
        if (nums.length == 0) {
            return 0;
        }
        // length of the array minus duplicates
        int length = 1;  
        
        // always track most recent unique value
        int mostRecent = nums[0]; 
        
        // var for storing offset from first duplicate
        int indexAfterDup = -1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != mostRecent) {  // Case 1: At non-duplicate index
                length++;
                mostRecent = nums[i]; 
                if (indexAfterDup > 0) {
                    nums[indexAfterDup] = nums[i];
                    indexAfterDup++;
                }
            } else { // Case 2: At index with duplicate
                if (indexAfterDup < 0) {
                    indexAfterDup = i; 
                }
            }
        }
        
        return length;
    }
}
