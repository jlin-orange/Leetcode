class Solution {
    // Map with key-value pairs, where the LIS is returned given an index
    HashMap<Integer, Integer> hm = new HashMap<>();         
    int maxLIS = 0;
    
    public int lengthOfLIS(int[] nums) {
        // starting from right, build HashMap so that memoization can be used
        // HashMap for LIS, 0-1 Knapsack Idea
        // store longest increasing subsequence with/without certain numbers and take the max of that
        // update a global var for LIS every time we have a LIS @ some index
        
        // Problem Variables: (what parameters are changing?)
        // 1. Array Position
        // 2. Integer Value
        // 3. Current Subsequence Length
        
        // Recurrence Relation:
        // First, see if a number if < or > than yourself. 
        // IF <, you can ignore it and move on to the next digit (unless at end)
        // ELSE IF >, (accept its LIS) OR (ignore + move on)
        
        // Base Cases:
        // 1. At end of the array
        
        // Implementation: "Recursive" (stack overflow problem) 
        
        // Memoization: store subproblems solutions in data strucuture
        // 1. STORE function result into memory before calling 'return'
        // 2. LOOK UP function result in memory before doing other 'computation'
        
        // Lastly, determine time complexity!! (# of total states * work done per state)

        if (nums.length <= 1) {
            return nums.length;
        }
        
        
        for (int index = nums.length-1; index >= 0; index--) { // iterates thru array backwards
            int localLIS = findLIS(nums, index + 1, 1, nums[index]);
            hm.put(index, localLIS);
            if (localLIS > maxLIS) { // updates maxLIS if a new one is found
                maxLIS = localLIS;
            }
        }
        return maxLIS;
    }    
    
    private int findLIS(int[] a, int currIndex, int currLIS, int prevBiggest) {
        if (currIndex == a.length) { // base case
            return currLIS;
        } else if (a[currIndex] <= prevBiggest) { // IGNORE - increment index by 1 only, no change to currLIS
            return findLIS(a, currIndex + 1, currLIS, prevBiggest); 
        } else { // (a[currIndex] > prevBiggest)
            int with;
            int without;
            // check map first
            if (hm.get(currIndex) != null) {
                with = currLIS + hm.get(currIndex);
            } else { // subproblem not already in map
                with = findLIS(a, currIndex + 1, currLIS + 1, a[currIndex]);
            }
            
            // ignore # at current index
            without = findLIS(a, currIndex + 1, currLIS, prevBiggest);
            
            return Math.max(with, without); 
        }    
    }
    
}
