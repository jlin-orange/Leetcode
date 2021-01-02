class Solution {
    // Local Variables
    // array of money available @ all houses
    int[] houseStashes;
    
    // # of houses on the street
    int numOfHouses;
    
    // map storing max money possible to have robbed @ any house 
    int[] maxMoneyMap;
    
    /*
    Main function for initializing Local Vars, catching edge cases, 
    calling DP method to build a map, and returning the end result 
    
    Runtime: O(n)  
    Space: O(n) 
    */
    public int rob(int[] nums) {
        houseStashes = nums;
        numOfHouses = houseStashes.length;
        
        // Edge Cases
        if (numOfHouses == 0) {
            return 0;
        } else if (numOfHouses == 1) {
            return houseStashes[0];
        }
        
        // Set initial values of our DP map -1 so houses w/0 money aren't ignored in our DP function
        maxMoneyMap = new int[numOfHouses];
        for (int i = 0; i < maxMoneyMap.length; i++) {
            maxMoneyMap[i] = -1;
        }
        
        robHouses(0, 0);
        
        return Math.max(maxMoneyMap[numOfHouses-1], maxMoneyMap[numOfHouses-2]);
    }
    
    /*
    DP function for recusrively traversing all houses
    
    Key idea here to avoid TLE is to only keep recursing
    when robbing a new pattern of houses proves to be 
    more profitable than what we've seen in the past (or by default)
    
    We do this by constantly checking & updating an Integer array ("map")
    which tracks the maximum amount of money we've made along a robbing 
    path @ any house along the street.
    
    Base Case/Return condition: we reach the end of the "street"
    */
    public void robHouses(int houseIndex, int money) {
        if (houseIndex >= numOfHouses) {
            return;
        } 
        int oldMax = maxMoneyMap[houseIndex];
        int currMax = houseStashes[houseIndex] + money;
        
        // only keep cases where our currMax is better, consequently we omit further traversal to save time 
        if (oldMax < currMax) { 
            maxMoneyMap[houseIndex] = currMax;
            
            // SKIP this house *Note: moving this line outside increases runtime!*
            robHouses(houseIndex+1, money); 
            
            // ROB this house, then skip the next one b/c constraints  
            robHouses(houseIndex+2, currMax); 
        } 
    }
    
}
