class Solution {
    /*
    Hash Table Solution
    1. store occurences of an integer in a HashMap
    2. for every integer stored in the map, 
    - use summations rule to add up all valid pairings
    - if n = # of occurences, totalPairs += n*(n+1) / 2
    3. return total pairs!
    
    Runtime: O(n)
    Space: O(n)
    */
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> occurenceMap = new HashMap<>();
        int totalPairs = 0;
        
        // Tally # of occurences ∀ int in nums
        for (int num : nums) {
            occurenceMap.put(num, occurenceMap.getOrDefault(num, 0) + 1);
        }
        t
        Iterator<Integer> valueIterator = occurenceMap.values().iterator();
        int n; // n = # of occurences for a value
        
        while (valueIterator.hasNext()) {
            n = valueIterator.next(); 
            if (n > 1) {
                totalPairs += n * (n-1) / 2;
            }
        }
        
        return totalPairs;
    }
}
