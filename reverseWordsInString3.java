class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        
        StringBuilder builder = new StringBuilder();
        
        char currChar; // track char while iterating thru string
        for (int i = 0; i < len; i++) {
            currChar = s.charAt(i);
            
            if (currChar == ' ') {
                addReverseWord(builder, i - 1, s); // start at index previous to the space
                builder.append(' '); // account for space @ end of each word 
            } else if (i == len - 1) { // catch the final word! 
                addReverseWord(builder, i, s);
            }
        }
        
        return builder.toString();
    }
    
    /*
    Takes the index of the last letter of a word and adds the whole
    word in reverse to a StringBuilder 
    */
    private void addReverseWord(StringBuilder sb, int index, String str) { 
        int currIndex = index;
        if (currIndex < 0) return;
        
        char currChar = str.charAt(currIndex); 
        while (currChar != ' ') {
            sb.append(currChar);
            currIndex--;
            
            if (currIndex < 0)  return;            

            currChar = str.charAt(currIndex);
        }
    } 
}
