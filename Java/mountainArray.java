class Solution {
    public boolean validMountainArray(int[] arr) {
        // 1. check strict increasing, return inflection index
        // 2. check strict decreasing from inflection to end of index
        int arrLength = arr.length;
        
        int peak = checkIncreasing(arr, arrLength);
        if (peak == -1) return false;
        
        return checkDecreasing(arr, arrLength, peak);
        
    }
    
    // Return the index at which numbers stop increasing
    public int checkIncreasing(int[] arr, int length) {
        int peak = 0;
        
        for (int i = 1; i < length; i++) {
            if (arr[i] - arr[i-1] <= 0) return i - 1;
            peak++;
        }
        
        return peak;
    }
    
    public boolean checkDecreasing(int[] arr, int length, int inflection) {
        if (inflection == 0) return false;
        
        if (inflection == length - 1) return false;
        
        for (int i = inflection; i < length - 1; i++) {
            if (arr[i] - arr[i+1] <= 0) return false;
        }
        
        return true;
    }
}