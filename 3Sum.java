class Solution {
    /*
    Sort + 2 Pointers Approach
    
    1. Sort array
    2. set outer integer to be target sum
    3. use two pointers to find integers that can reciprocate target (while avoiding dups)
    
    Time: O(n^2) , Space: O(n)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums.length < 3) {
            return results;
        } 
        
        Arrays.sort(nums); // sort to easily avoid duplicate triplets
        
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) { // End early when only positive integers remaining
                break;
            } else if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // Use 2 pointers to find integers that sum to our target
            int target = -nums[i]; 
            int lo = i+1; int hi = n-1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++; hi--;
                    
                    // Dodge duplicate integers
                    while (lo < hi && nums[lo] == nums[lo-1]) lo++; 
                    while (lo < hi && nums[hi] == nums[hi+1]) hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else { // nums[lo] + nums[hi] > target
                    hi--;
                }
            }
        }
        return results;
    }
}

// class Solution {
//     /*
//     Brute force Solution - TLE
//     Time: O(n^3) , Space: O(n)
//     */
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> results = new ArrayList<List<Integer>>();
//         HashSet<ArrayList<Integer>> validTriplets = new HashSet<>();
        
//         if (nums.length < 3) {
//             return results;
//         } 
        
//         int n = nums.length;
//         int[][] map = new int[n-2][n-1]; 
//         for (int i = 0; i < n-2; i++) {
//             for (int j = i+1; j < n-1; j++) {
//                 map[i][j] = nums[i] + nums[j];
//                 for (int k = j+1; k < n; k++) {
//                     if (map[i][j] + nums[k] == 0) {
//                         ArrayList<Integer> triplet = new ArrayList<>();
//                         triplet.add(nums[i]);
//                         triplet.add(nums[j]);
//                         triplet.add(nums[k]);
//                         Collections.sort(triplet);

//                         if (!validTriplets.contains(triplet)) {
//                             results.add(triplet);
//                             validTriplets.add(triplet);
//                         } 
//                     }
//                 }
//             }
//         }
//         return results;
//     }
// }
