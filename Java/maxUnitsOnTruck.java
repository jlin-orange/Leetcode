class Solution {
    // Runtime: O(truckSize), Space: O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 1.) sort the boxTypes by # of units! 
        // 2.) take as many boxes as you can, starting with the boxes containing the highest amount of units
        
        int remainingSpace = truckSize;
        int maxUnits = 0;
        
        Arrays.sort(boxTypes, (a, b) -> Double.compare(a[1], b[1]));
        
        int totalTypes = boxTypes.length;
        if (totalTypes == 0) return maxUnits;
        
        // Greedily add high-unit boxes (which we sorted for) till they're out of stock
        for (int i = totalTypes - 1; i >= 0; i--) {
            while (boxTypes[i][0] > 0) {
                maxUnits += boxTypes[i][1]; 
                
                // Update the array + truck space
                boxTypes[i][0]--;
                remainingSpace--;
                
                if (remainingSpace == 0) return maxUnits;
            }   
        }
    
        return maxUnits;
    }
}