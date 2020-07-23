class Solution {
    /*
    Counting Sort solution 
    - Fastest of the solutions! But only because we have an input constraint s.t. [0 <= nums[i] <= 100]
    
    Time: O(n) - 3 for-loops
    Space: O(n)
    */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        
        // Tracks occurences of a number by index
        int[] countArray = new int[101];
        
        // Tally # occurences to our counting array (which is "sorted" by implementation)
        for (int i = 0; i < len; i++) {
            countArray[nums[i]]++;
        }
        
        // Tracks total # of nums smaller than number at any index
        int[] totalSmallerArray = new int[101];
        
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) { // adds/stores up the total occurence of lower #s as we ascend
            totalSmallerArray[i] = sum;
            sum += countArray[i];
        }
        
        // Get our results
        int[] results = new int[len];
        for (int i = 0; i < len; i++) {
            results[i] = totalSmallerArray[nums[i]];
        }
        
        return results;
    }
    
//     /*
//     HashMap Solution
    
//     Time: O(nlgn) - from sorting
//     Space: O(n) - HashMap 
//     */
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int length = nums.length;
//         HashMap<Integer, Integer> countMap = new HashMap<>(); // map for storing sorted position of an integer
        
//         int[] copy = nums.clone();
//         Arrays.sort(copy);
        
//         for (int i = 0; i < length; i++) {
//             countMap.putIfAbsent(copy[i], i);
//         }
        
//         int[] results = new int[length];
//         for (int i = 0; i < length; i++) {
//             results[i] = countMap.get(nums[i]);
//         }
        
//         return results;
//     }
    
    /*
    Brute Force
    Time: O(n^2)
    Space: O(n)
    */
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int[] ans = new int[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             int smallerCount = 0;
//             for (int j = i; j < nums.length; j++) {
//                 if (nums[j] < nums[i]) {
//                     smallerCount++;
//                 }
//             }
//             smallerCount += countSmallerBehind(nums, i);
//             ans[i] = smallerCount;
//         }
        
//         return ans;
//     }
    
//     public int countSmallerBehind(int[] nums, int index) {
//         int count = 0;
//         int target = nums[index];
        
//         for (int i = index; i >= 0; i--) {
//             if (nums[i] < target) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
}
