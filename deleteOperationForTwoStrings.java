public class Solution {
    /*
    A twist on the classic Longest Common Subsequence problem (#1143)
    (a DP classic~)
    
    The definition for a subsequence is as follows (excerpted from #1143):
    "A subsequence of a string is a new string generated from the original string with some 
    characters (>= 0) deleted w/o changing the relative order of the remaining characters. 
    Ex: For sequence "ABCDE", "ACE" IS a subsequence | "AEC" is NOT). 
    
    A "common subsequence" of two strings is a subsequence found in both strings.
    
    Time: O(m*h) , Space: O(m*n) 
    ...where {m = s1.length, n = s2.length}
    */
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        
        int[][] memo = new int[m + 1][n + 1];
        
        int totalLength = s1.length() + s2.length();
        int longestCommonSubseq = lcs(s1, s2, s1.length(), s2.length(), memo);
        
        // gives us the # of deletions necessary to give us the longest common subsequence
        int minDeletions = totalLength - 2 * longestCommonSubseq; 
        
        return minDeletions;
    }
    
    /*
    Recursively (top-down) deduce the LCS using memoization
    */
    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        // Edge case: string is exhausted
        if (m == 0 || n == 0)
            return 0;
        
        // Already know the LCS given current string lengths
        if (memo[m][n] > 0)
            return memo[m][n];
        
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) // add 1 to subsequence count before continuing recursion
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else // take max common subsequence in variations from our current strings
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        
        return memo[m][n]; // max common subsequence given string lengths m & n
    }
}
