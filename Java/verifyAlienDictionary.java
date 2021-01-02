class Solution {
    // Sort from smallest to largest lexicographicaly
    // ex: app < apple
    // To check for sortedness, we only need to check if words are sorted relative to their neighbor!
     
    // Insert lexicographical order into HashTable  
    // then, compare every word up until last one (make comparator to compare Strings)
     
    // Time: O(n) where n = total content of words , Space: O(1)
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        
        HashMap<Character, Integer> lexicalMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            lexicalMap.put(order.charAt(i), i);
        }
        
        // compare every word up until the last one
        for (int i = 0; i < words.length-1; i++) {
            String firstWord = words[i];
            String secondWord = words[i+1];
            if (alienCompare(firstWord, secondWord, lexicalMap) == false) {
                return false;
            }
        }
        return true;
    }
    
    /*
    Checks if "string a" is lexicographically smaller than "string b" 
    
    false if A is longer than B & letters are same
    */
    public boolean alienCompare(String a, String b, HashMap<Character, Integer> map) {
        int minLength = a.length() <= b.length() ? a.length() : b.length();
        
        // Lexicographically compare letters up to the length of the shorter word
        for (int i = 0; i < minLength; i++) {
            if (map.get(b.charAt(i)) > map.get(a.charAt(i))) { 
                return true;
            } else if (map.get(b.charAt(i)) < map.get(a.charAt(i))) {
                return false;
            }
            // else letters equal, continue in loop to look at remaining letters
        }
        
        // if all the letters up to the shortest length are equal, "string a" needs to be shorter 
        // in length for our words to be in lexicographical order. 
        return a.length() < b.length() ? true : false;
    }

}
