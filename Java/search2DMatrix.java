class Solution {
    /*
    Time: O(lg(m)+lg(n)) , Space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        
        int height = matrix.length - 1;
        int width = matrix[0].length - 1;
        
        // Edge cases
        int smallestNum = matrix[0][0];
        int largestNum = matrix[height][width];
        if (target == smallestNum || target == largestNum) {
            return true;
        } else if (target < smallestNum || target > largestNum) {
            return false;
        }
        
        int rowLowerBound = 0;
        int rowUpperBound = height;
        
        // Binary search that narrows down our search to the row w/our target
        while (rowLowerBound < rowUpperBound) {
            int midRow = (rowLowerBound + rowUpperBound) / 2;
            int rowStart = matrix[midRow][0];
            int rowEnd = matrix[midRow][width];
            
            if (rowStart == target || rowEnd == target) {
                 return true;
            } else if (target < rowStart) { // target is in earlier row, so decrease upper bound
                rowUpperBound = midRow - 1;
            } else if (target > rowEnd) { // target is past current value, so set current row to lower bound
                rowLowerBound = midRow + 1;
            } else { // target > rowStart -> currentRow must contain target (if exists)
                rowUpperBound = midRow;
                rowLowerBound = midRow; // satisfy exit condition
            }
        }
        
        int finalRow = rowUpperBound; 
        
        int colLowerBound = 0;
        int colUpperBound = width;
        
        while (colLowerBound <= colUpperBound) {
            int midCol = (colLowerBound + colUpperBound) / 2;
            int currentValue = matrix[finalRow][midCol];
            
            if (currentValue == target) {
                 return true;
            } else if (target > currentValue) { // target is past current value, so increase lower bound
                colLowerBound = midCol + 1;
            } else { // target < currentValue -> target is earlier in row, so decrease upper bound
                colUpperBound = midCol - 1;
            }
        }
        
        return false;
    }
}
