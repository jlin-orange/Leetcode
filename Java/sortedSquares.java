package Java;

public class sortedSquares {
    
    public int[] sortedSquares(int[] nums) {
        // Perform swaps if the negative numbers if larger!
        int lo = 0;
        int hi = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                nums[i] = nums[hi] * nums[hi];
                hi--;
            } else {
                nums[i] = nums[lo] * nums[lo];
                lo++;
            }
        }
        
        return nums;
    }
}
