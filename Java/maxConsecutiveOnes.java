/*
Find the max # of consecutive ones with some local variables.
One LV tracks the max streak of ones ever found. Another variable 
is used to track current streaks to see if anything longer can be found

Time: O(n), Space: O(1)
*/
class Solution {
    // Time: O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int maxCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currCount++;
            } else {
                maxCount = Math.max(currCount, maxCount);
                currCount = 0;
            }
        }
        maxCount = Math.max(currCount, maxCount); 
        
        return maxCount;
    }
}