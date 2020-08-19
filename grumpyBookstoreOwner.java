class Solution {
    /*
    Use a sliding window of "X" size to keep track of the most customers missed due to a grumpy owner. We return the max missed customers in addition to the customers who would be satisfied normally with an ungrumpy owner.
    
    Time: O(n) , Space: O(1)
    */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        
        // Tracks the total customers missed in a window size "X" due to owner's grumpiness
        int bestWindow = 0;
        
        // Borders for a sliding window
        int L = 0; int R = -1 + X;
        
        // Slide window through the whole array, searching for the largest window
        int currWindow = firstWindow(customers, grumpy, X);
        bestWindow = currWindow;
        for (int i = 0; i < n - X; i++) {
            if (grumpy[L] == 1) currWindow -= customers[L];
            L++; R++;
            if (grumpy[R] == 1) currWindow += customers[R];
            if (currWindow > bestWindow) bestWindow = currWindow;
        }
        
        return totalSatiety(customers, grumpy) + bestWindow;
    }    
    
    /*
    Total missed customers due to grumpiness in first X window
    */
    private int firstWindow(int[] customers, int[] grumpy, int X) {
        int grumpSum = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) grumpSum += customers[i];
        }
        return grumpSum;
    }
    
    /*
    Sum of satisfied customers when owner isn't grumpy by default 
    */
    private int totalSatiety(int[] customers, int[] grumpy) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        } 
        return sum;
    }
}
