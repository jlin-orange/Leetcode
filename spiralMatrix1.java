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
        List<Integer> l = new ArrayList<>();
        
        int height = matrix.length; if (height < 1) {return l;}
        int width = matrix[0].length;
        int n = height*width;
        
        // Initial Left/Right/Top/Bottom bounds respectively
        int lb = -1;
        int rb = width;
        int tb = 0;
        int bb = height; // # of columns
        
        // x,y = col index,row index
        // matrix[y][x] = matrix[row][col]
        int x = 0;
        int y = 0;
        
        // Direction Key: 0 = Right, 1 = Down, 2 = Left, 3 = Up
        int dir = 0;
        
        for (int i = 1; i <= n; i++) {
            l.add(matrix[y][x]);
            switch (dir) {
                // Check bounds @ each element: 
                    // if out-of-bound, change direction/update bounds
                case 0: // turn down [for what!]
                    if (x+1 == rb) { 
                        y++; rb--;
                        dir = 1;
                    } else {
                        x++;
                    }
                    break;
                
                case 1: // Down
                    if (y+1 == bb ) { // turn left
                        x--; bb--;
                        dir = 2;
                    } else {
                        y++;
                    }
                    break;
                    
                case 2: // Left
                    if (x-1 == lb) { // turn up
                        y--; lb++;
                        dir = 3;
                    } else {
                        x--;
                    }
                    break;
                
                case 3: // Up
                    if (y-1 == tb) { // turn right
                        x++; tb++;
                        dir = 0;
                    } else {
                        y--;
                    }
                    break;
            }
        }
        return l;
    }
}
