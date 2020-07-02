class Solution {
    /*
    * Time: O(s.length)
    * Space: O(s.length)
    */
    public int firstUniqChar(String s) {
        // Track # of times a character appears in
        HashMap<Character, Integer> numOccur = new HashMap<>();
        
        // Tracks index @ which a character first appears 
        HashMap<Character, Integer> firstOccur = new HashMap<>();
        
        // Populate both helper HashMaps
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int charOccur = numOccur.getOrDefault(currChar, 0) + 1;
            if (charOccur == 1) {
                firstOccur.put(currChar, i);
            }
            numOccur.put(currChar, charOccur);
        }
        
        // Return a character's index, if it only appears once in 's'
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (numOccur.get(currChar) == 1) {
                return firstOccur.get(currChar);
            }
        }
        return -1;
    }
}
