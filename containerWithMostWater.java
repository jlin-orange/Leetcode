class Solution {
    /*
    Two Pointers Solution
    
    Time: O(n), Space: O(1)
    */
    public int maxArea(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int length;
        
        int maxArea = 0; int currMax = 0;
        
        // Two pointers iterate towards one another while keeping track of max area
        while (left < right) {
            length = right - left;
            currMax = length * Math.min(height[left], height[right]);
            maxArea = Math.max(currMax, maxArea);
            
            // Look for next tallest line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
