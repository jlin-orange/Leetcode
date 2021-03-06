class Solution {
    /**
    * Time: O(nlgn) - due to sorting
    * Space: O(n) - copy of array + a hashmap for each unique integer
    * Results: 5.22% faster runtime, 100% less space usage
    */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortArr = Arrays.copyOf(nums, nums.length); // have to copy array before sorting to preserve the input for later
        Arrays.sort(sortArr);
        int[] smallerNums = new int[nums.length]; // our answer array
        HashMap<Integer, Integer> hm = new HashMap<>(); // tracks integers we've seen before
        
        // puts every unique integer in a hashMap along w/the count of lesser elements
        for (int i = sortArr.length - 1; i >= 0; i--) {
            int totalSmaller = 0;
            if (hm.get(sortArr[i]) == null) { // if not already recorded in HashMap
                for (int j = i; j >= 0; j--) {
                    if (sortArr[j] < sortArr[i]) { // goes backward thru sortedList until a smaller number is found
                        totalSmaller = j+1;
                        System.out.println(j);
                        j = -1;
                    }
                hm.put(sortArr[i], totalSmaller);
                }
            }
        }
        
        for (int z = 0; z < nums.length; z++) { // uses hashMap to correctly populate our answer array
            smallerNums[z] = hm.get(nums[z]);
        }
    
        return smallerNums;
        
    }
}
