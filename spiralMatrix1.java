class Solution {
    /*
    Keep track of 4 bounds (Left, Right, Top, Bottom) that 
    gradually shrink (update) as you traverse your 2D array, adding
    element to a list. [Key Features: Array Traversal, Switch statement]
    
    Direction of Spiral Matrix Traversal:
    START (top-left most element -> RIGHT-bound -> BOTTOM-bound -> LEFT-bound -> TOP-bound) -> REPEAT 
    
    When traversing, make sure your next current index within bounds,
    otherwise you must change directions!
    
    Use a switch statement to track your directions
    and update your bounds according to traversal progress.
    
    Example:
    
    Input:
    [(0,0)          (2,0)
         [[ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]]
     (0,2)          (2,2)
     
    Output: [1,2,3,6,9,8,7,4,5]
    
    Time: O(n) , Space: O(n) 
    */
    public List<Integer> spiralOrder(int[][] matrix) {       
        // list for returning elements in spiral order
        List<Integer> result = new ArrayList<>();
        
        int height = matrix.length; if (height < 1) return result;
        int width = matrix[0].length;
        int n = height*width;
        
        // Initial Left/Right/Top/Bottom bounds respectively
        int leftBound = -1;
        int rightBound = width;
        int topBound = 0;
        int bottomBound = height; // # of columns
        
        // x,y = col index,row index
        // matrix[y][x] = matrix[row][col]
        int x = 0;
        int y = 0;
        
        // Direction Key: 0 = Right, 1 = Down, 2 = Left, 3 = Up
        int dir = 0;
        
        for (int i = 1; i <= n; i++) {
            result.add(matrix[y][x]);
            switch (dir) {
                // Check bounds @ each element: 
                    // if out-of-bound, change direction/update bounds
                case 0: // turn down [for what!]
                    if (x+1 == rightBound) { 
                        y++; rightBound--;
                        dir = 1;
                    } else {
                        x++;
                    }
                    break;
                
                case 1: // Down
                    if (y+1 == bottomBound ) { // turn left
                        x--; bottomBound--;
                        dir = 2;
                    } else {
                        y++;
                    }
                    break;
                    
                case 2: // Left
                    if (x-1 == leftBound) { // turn up
                        y--; leftBound++;
                        dir = 3;
                    } else {
                        x--;
                    }
                    break;
                
                case 3: // Up
                    if (y-1 == topBound) { // turn right
                        x++; topBound++;
                        dir = 0;
                    } else {
                        y--;
                    }
                    break;
            }
        }
        return result;
    }
}
