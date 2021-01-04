class Solution {
    // Boyer-Moore Voting Algorithm using a stack
    // Space: O(n) , Time: O(n)
    public int majorityElement(int[] nums) {
        // 1) if stack empty, push
        // 2) if stack full: (if equal, push. Else, pop)
        LinkedList<Integer> numStack = new LinkedList<>();
        
        
        for (int num : nums) {
            if (numStack.isEmpty()) {
                numStack.push(num);
            } else {
                if (numStack.peek() == num) {
                    numStack.push(num);
                } else {
                    numStack.pop();
                }
            }
        }
        
        return numStack.pop();
    }
}
