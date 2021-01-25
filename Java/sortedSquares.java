package Java;

public class sortedSquares {
    // Two pointers approach to populating an answer array with the highest magnitude squares first.
    // Note: The left pointer helps catch negative numbers with a large magnitude 
    
    // Time: O(n)    Space: O(n) - for the answer array
    public int[] sortedSquares(int[] nums) {
        int arrLength = nums.length;
        int[] ans = new int[arrLength];

        int lo = 0;
        int hi = arrLength - 1;

        // Two pointers approach to squaring and storing all the highest magnitude integers first.
        for (int i = arrLength - 1; i >= 0; i--) {
            // Use Absolute value to determine magnitude of a number
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                ans[i] = nums[hi] * nums[hi];
                hi--;
            } else {
                ans[i] = nums[lo] * nums[lo];
                lo++;
            }
        }

        return ans;
    }
}
