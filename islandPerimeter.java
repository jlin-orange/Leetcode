class Solution {
    public class Tuple<X, Y> { 
        public final X x; 
        public final Y y; 
        public Tuple(X x, Y y) { 
            this.x = x; 
            this.y = y; 
        } 
    } 
    
    int[][] islandMap;
    int height;
    int width;
    int perimeter = 0;
    
    /*
    Don't want to revisit squares: set of Tuples (coords)
    Also, don't want to index squares out of bounds
    
    - check neighbor, if valid +1 to neighbors 
    - run recursive function on neighbor
    - if invalid, return 0
    - perimter += 4 - # neighbors
    
    */
    public int islandPerimeter(int[][] grid) {
        islandMap = grid;
        height = islandMap.length - 1;
        width = islandMap[0].length - 1;
        
        for (int row = 0; row < height+1; row++) {
            for (int col = 0; col < width+1; col++) {
                if (grid[row][col] == 1) {
                    islandMap[row][col] = -1;
                    calculatePerimeter(row, col); // start find perimeter when we strike land!!
                    return perimeter;
                } 
            }
        }
        return perimeter;
    }
    
    public void calculatePerimeter(int row, int col) {
        islandMap[row][col] = -1; // mark we've visited this square
        
        int numOfNeighbors = 0;
        
        if (isNeighbor(row+1, col)) {
            numOfNeighbors++;
            if (islandMap[row+1][col] == 1) {
                calculatePerimeter(row+1, col);
            }     
        }
        
        if (isNeighbor(row-1, col)) {
            numOfNeighbors++;
            if (islandMap[row-1][col] == 1) {
               calculatePerimeter(row-1, col); 
            }    
        }
        
        if (isNeighbor(row, col+1)) {
            numOfNeighbors++;   
            if (islandMap[row][col+1] == 1) {
                calculatePerimeter(row, col+1);
            }  
        }
        
        if (isNeighbor(row, col-1)) {
            numOfNeighbors++;
            if (islandMap[row][col-1] == 1) {
                calculatePerimeter(row, col-1);
            } 
        }
             
        perimeter += 4 - numOfNeighbors;
        return;
    }
    
    /*
    3 conditions 
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
