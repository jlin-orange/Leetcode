class Solution {
    /*
    Approach:
    1) Perform binary addition using a 'carry' local variable
    
    2) Iterate from the back of each string as binary numbers are represented reverse to 
      how we normally read things
    
    3) add the result of each single sum to a stack
    
    4) pop stored results off the stack + into a string build
      so our string is built with the correct ordering (o.w. our string would be backwards)
    
    Time: O(m+n) , Space: O(m + n)...where m = a.length() , n = b.length()
    */
    public String addBinary(String a, String b) {
        int s1Len = a.length();
        int s2Len = b.length();
        
        StringBuilder sumString = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        
        int carry = 0;
        
        int i = 0;
        while (i < s1Len || i < s2Len) {
            int intA = (i < s1Len) ? Integer.parseInt(a.substring(s1Len - i - 1, s1Len - i)) : 0;
            int intB = (i < s2Len) ? Integer.parseInt(b.substring(s2Len - i - 1, s2Len - i)) : 0;
            
            int sum = intA + intB + carry;
            stack.push(sum % 2);
            
            carry = (sum >= 2) ? 1 : 0; 
            // alternatively: carry = sum / 2;
            
            i++;
        }
        
        if (carry > 0) stack.push(1);
        
        while (!stack.isEmpty()){
            sumString.append(stack.pop());
        }
        
        return sumString.toString(); // If you don't want to implement a stack: sumString.reverse().toString() 
    }
}
