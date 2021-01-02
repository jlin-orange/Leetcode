class Solution {
    /*
    Judge will always be the most trusted!
    - 2 iterations, one to find one is most trusted, one to check that they don't trust others
    
    Time: O(n) , Space: O(n)
    */
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return N;
        }
        
        int maxTrust = 0;
        int mostTrustedPerson = 0;
        
        // Array that tracks how trusted each person is
        int[] accumulatedTrust = new int[N+1];
        
        // Tally up the total trust each person accumulates while tracking the most trusted individual 
        for (int[] pair : trust) {
            int currentPerson = pair[1];
            int currentTrust = accumulatedTrust[currentPerson];
            currentTrust += 1;
            if (currentTrust > maxTrust) {
                maxTrust = currentTrust;
                mostTrustedPerson = currentPerson;
            }
            accumulatedTrust[currentPerson] = currentTrust;
        }
            
        // If one person is trusted by everybody, we can only know 
        // that they are a judge if they don't trust anyone. 
        if (accumulatedTrust[mostTrustedPerson] == N-1) {
            for (int[] pair : trust) {
                int trustee = pair[0];
                if (trustee == mostTrustedPerson) {
                    return -1;
                }
            }
            return mostTrustedPerson;
        } else {
            return -1;
        }
    }
}
