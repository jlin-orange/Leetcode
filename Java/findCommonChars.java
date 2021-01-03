class Solution {
    public List<String> commonChars(String[] A) {
        int[][] charCount = new int[A.length][26];
        
        for (int i = 0; i < A.length; i++) {
            int stringLength = A[i].length();
            // Tally up count of each char in a word
            for (int j = 0; j < stringLength; j++) {
                int charIndex = A[i].charAt(j) - 'a';
                charCount[i][charIndex]++;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            int commonOccurences = 101;
            char currChar = (char) (i + 'a');
            
            for (int word = 0; word < A.length; word++) {
                commonOccurences = Math.min(charCount[word][i], commonOccurences);
            }
            
            for (int count = commonOccurences; count > 0; count--) {
                ans.add(Character.toString(currChar));
            }
        }
        
        return ans;
    }
}
