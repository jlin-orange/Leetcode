class Solution {
    /*
    Init two arrays which will track the sum @ each index 
    starting from either the front OR back of the array. 
    
    After, iterate one final time to see if there's any index
    where the (sum on left) == (sum on right)
    
    Time: O(n) , Space: O(n)
    */
    public int pivotIndex(int[] nums) {
        int n = nums.length; 
        if (n == 0) {
            return -1;
        }
        
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        // Calculate all sums starting from the left
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            leftSum[i] = sum;
        }
        
        // Calculate all sums starting from the right
        sum = 0;
        for (int i = n-1; i >= 0; i--) {
            sum += nums[i];
            rightSum[i] = sum;
        }
        
        // check edge cases and in-between for pivot index
        if (rightSum[1] == 0) return 0;
 
        for (int i = 1; i < n-1; i++) {
            if (leftSum[i-1] == rightSum[i+1]) { // sums are equal on left/right of pivot
                return i;
            }
        }
        
        if (leftSum[n-2] == 0) return n-1;
        
        return -1;
    }
}
