package Java;

public class fibonacci {
    // Recursive Solution
    //     public int fib(int n) {
    //         if (n <= 0) return 0;
    //         if (n == 1) return 1;
            
    //         return fib(n-1) + fib(n-2);
    //     }
        
    // Iterative (DP) Solution. Time: O(n), Space: O(n)
    public int fib(int n) {
        // Edge Cases
        if (n <= 1) return n;
        
        // Create a DP array of length n
        int[] fibArray = new int[n+1]; 
        
        // Initialize two starter cases
        fibArray[0] = 0;
        fibArray[1] = 1;
        
        // Iteratively find the desired fibonacci number
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }
        
        return fibArray[n];
    }
}
