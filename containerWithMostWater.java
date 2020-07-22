class Solution {
    /*
    Two Pointers Solution
    
    Time: O(n), Space: O(1)
    */
    public int maxArea(int[] height) {
        int low = 0; 
        int high = height.length - 1;
        int length;
        
        int maxArea = 0; int currMax = 0;
        
        // Two pointers iterate towards one another while keeping track of max area
        while (low < high) {
            length = high - low;
            currMax = length * Math.min(height[low], height[high]);
            maxArea = Math.max(currMax, maxArea);
                
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return maxArea;
    }
}
