class Solution {
    /*
    Time: O(n), Space: O(1)
    */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int currWord = 1;
        int prefixLength = searchWord.length();
        
        if (prefixLength == 0) {
            return 1;
        }
        
        boolean isPrefix = true;
        for (int i = 0; i < sentence.length() - prefixLength + 1; i++) {
            if (sentence.charAt(i) == ' ') {
                currWord++;
                isPrefix = true;
            } else if (isPrefix) {
                if (sentence.substring(i, i + prefixLength).equals(searchWord)) {
                    return currWord;
                }
                isPrefix = false;
            }
        }
        
        return -1;
    }
}
