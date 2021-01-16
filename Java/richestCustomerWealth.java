package Java;

public class richestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        int totalAccounts = accounts.length;
        if (totalAccounts == 0) return maxWealth;
        
        int accountSize = accounts[0].length;
        
        for (int i = 0; i < totalAccounts; i++) { 
            int currentWealth = 0;
            for (int j = 0; j < accountSize; j++) {
                currentWealth += accounts[i][j];
            }
            maxWealth = Math.max(currentWealth, maxWealth);
        }
        
        return maxWealth;
    }
}
