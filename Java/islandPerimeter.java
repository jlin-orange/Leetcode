class Solution {
    /*
    Basic Implementation of a 2-element Tuple (aka Pair)
    */
    public class Tuple<X, Y> { 
        public final X x; 
        public final Y y; 
        public Tuple(X x, Y y) { 
            this.x = x; 
            this.y = y; 
        } 
    } 
    
    // Local Variables
    int[][] islandMap;
    
    // Dimensions of our island
    int height; int width;
    
    // Counter for the total perimeter of our island
    int perimeter = 0;
    
    /*
    Main method for calculating the perimeter of the island in our grid
    
    Steps:
    1. Initialize Local variables
    2. Find our first block of land 
    3. Since there is exactly one island, we can call 
    our recursive land-searching method to tally up
    the total perimeter of our island
    
    Runtime: O(m*n)
    Space: O(1), in-place since we modify the argument grid
    */
    public int islandPerimeter(int[][] grid) {
        islandMap = grid;
        height = islandMap.length - 1;
        width = islandMap[0].length - 1;
        
        // start calculating perimeter when we strike land!
        for (int row = 0; row < height+1; row++) {
            for (int col = 0; col < width+1; col++) {
                if (grid[row][col] == 1) {
                    calculatePerimeter(row, col); 
                    return perimeter;
                } 
            }
        }
        return perimeter;
    }
    
    /*
    Calculates the perimeter for each block of land 
    individually in a recursive fashion. 
    
    How does it do this?
    1. Check cardinal directions for land and tally up outer edges (i.e. edges facing water)
    2. If a neighboring coordinate is unvisited land, visit it! 
    3. Add total # of outeredges to our 'perimeter' local variable
    */
    public void calculatePerimeter(int row, int col) {
        islandMap[row][col] = -1; // mark visited squares
        
        int outerEdges = 0;
        
        if (!isNeighbor(row+1, col)) {
            outerEdges++;
        } else {
            if (islandMap[row+1][col] == 1) { // only calculate perimeter for unseen land
                calculatePerimeter(row+1, col);
            }
        }
        
        if (!isNeighbor(row-1, col)) {
            outerEdges++;
        } else {
            if (islandMap[row-1][col] == 1) {
                calculatePerimeter(row-1, col);
            }
        }
        
        if (!isNeighbor(row, col+1)) {
            outerEdges++;
        } else {
            if (islandMap[row][col+1] == 1) {
                calculatePerimeter(row, col+1);
            }
        }
        
        if (!isNeighbor(row, col-1)) {
            outerEdges++;
        } else {
            if (islandMap[row][col-1] == 1) {
                calculatePerimeter(row, col-1);
            }
        }
        
        perimeter += outerEdges;
        return;
    }
    
    /*
    Returns if the neighboring coordinate of a block is 
    actually a valid block of land within the island grid
    
    Two Conditions to Satisfy:
    1. Within Boundaries of the Island
    2. Has a value of 1 = NOT a block of water)
    */
    public boolean isNeighbor(int row, int col) {
        if (row < 0 || col < 0 || row > height || col > width) {
            return false;
        }
        
        if (islandMap[row][col] == 0) {
            return false;
        } 
        
        return true; // if islandMap[row][col] = +/- 1
    }
    
}
