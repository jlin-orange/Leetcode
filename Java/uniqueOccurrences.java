class Solution {
    /*
    * Time: O(n) - iterate through array to store values in a dict
    * Space: O(n) - have to store occurences for potentially every unique integer
    */
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int num : arr) { // counts up occurences of a number
            if (hm.get(num) == null) {
                hm.put(num, 1);
            } else {
                hm.put(num, hm.get(num)+1);
            }
        }
        
        // puts values into a set 
        for (int val : hm.values()) {
            if (set.contains(val)) {
                return false;
            } else {
                set.add(val);
            }
        }
        
        return true;
    }
}
