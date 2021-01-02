class Solution {
    /*
     Time: O(numRows*numCols)
     Space: O(1)
    */
    int numCols;
    int numRows;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        numCols = image[0].length - 1;
        numRows = image.length - 1;
        
        // case where newColor == oldColor
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    public void dfs(int[][] img, int r, int c, int oldColor, int newColor) {
            if (r > numRows || c > numCols || r < 0 || c  < 0) {
                return;
            } else {
                if (img[r][c] == oldColor) {
                    img[r][c] = newColor;
                    dfs(img, r+1, c, oldColor, newColor);
                    dfs(img, r-1, c, oldColor, newColor);
                    dfs(img, r, c+1, oldColor, newColor);
                    dfs(img, r, c-1, oldColor, newColor);
                } else {
                    return;
                }
            }
        }
    
}
