class Solution {
    /*
    Stack contains:
    - the index of temps which no warmer day have occurred yet
    - temp indices on stack @ end of loop thru T (temps list) will get a value 0 
    
    - peek local temps as iterating thru T
    - as soon as find warmer temp, input the diff between current index & popped (@ popped index) 
    
    Time: O(n) , Space: O(n)
    */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] daysToWait = new int[n];
        
        // Holds indices of temps that haven't had warmer days since appearing
        Stack<Integer> tempStack = new Stack<>();
        
        int currTemp;
        for (int i = 0; i < n; i++) {
            currTemp = T[i];
            // tracks waiting time until a warmer temp found for days on the stack 
            while(!tempStack.isEmpty() && T[tempStack.peek()] < currTemp) {
                int lastColderDay = tempStack.pop();
                int daysWaited = i - lastColderDay;

                daysToWait[lastColderDay] = daysWaited;
            }
            
            tempStack.push(i); // all days go on the stack to see if a warmer future exists
        }
        
        // addresses the indices of days w/o warmer futures 
        while (!tempStack.isEmpty()) {
            int noWarmer = tempStack.pop();
            daysToWait[noWarmer] = 0;
        }
        
        return daysToWait;
    }
}
