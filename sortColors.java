class Solution {
    /*
    * Prompt:
    * Given an array with n objects colored red, white or blue, sort them in-place 
    * so that objects of the same color are adjacent, with the colors 
    * ORDERED: [red (0) -> white (1) -> blue (2)] 
    * Example: [0,0,1,1,2]
    *
    * Approach:
    * 0s will always be at the front [LEFT-side] of the array 
    * 2s will always be at the back [RIGHT-side] of the array
    * 1s consequently are between
    * My approach uses local vars to leverage this fact, constantly
    * tracking the correct index at which to insert the next 0 or 2
    * I do this while iterating thru the array (w/a pointer)
    *
    * Time: O(n) - 1 pass thru nums, Space: O(1) - local variables
    */
    public void sortColors(int[] nums) {
        // Indices for inserting most recently found 0/2 values
        int nextZero = 0;
        int nextTwo = nums.length-1;
    
        // for swaps; holds index elements (colors) 
        int tmp; 
        
        // Edge case
        if (nums.length == 1) {
            return;
        }
        
        // Iterates thru nums as long as there are potential 2s we have not discovered 
        int i = 0; 
        while (i <= nextTwo) { 
            if (nums[i] == 0) {
                if (i == nextZero) {
                    nextZero++;
                } else { // If i != nextZero, there must be a 1 earlier in our array
                    tmp = nums[nextZero];
                    nums[nextZero] = nums[i];
                    nums[i] = tmp;
                    nextZero++;
                }
            } else if (nums[i] == 2) { // if nums[i] == 2
                while (nums[nextTwo] == 2){ // found a two that's already in place
                    if (nextTwo == i) { // return if everything is fine up to index
                        return;
                    }
                    nextTwo--;
                } 
                if (nums[nextTwo] == 0) { // swap 2 with 0 OR the value sitting @ nextZero 
                    if (i != nextZero) {
                        nums[nextTwo] = 2;
                        tmp = nums[nextZero];
                        nums[nextZero] = 0;
                        nums[i] = tmp;
                        nextZero++;
                    } else { // i == nextZero
                        nums[nextTwo] = 2;
                        nums[nextZero] = 0;
                        nextZero++;
                    }
                }
                
                if (nums[nextTwo] == 1) { // swap 2 with 1
                    nums[nextTwo] = 2;
                    nums[i] = 1;
                }
                nextTwo--;
            }
            i++;
        }
        return;
    }
}
