class Solution {
    /*
    Goal: 
    - Return a list of cell that flow to both Pacific (left/top) OR Atlantic (right/bottom)
    
    Restrictions: 
    - Water can only flow to cells with equal or lower height 
    
    Plan of attack:
    - Init 2-D boolean array to keep track of squares that the Pacific/Atlantic
    Ocean can flow to from their respective borders
    - We will populate this array using DFS to look in all 4 directions (stored in integer array)
    - 4 total borders are as such: |  Pacific = 1st row/1st column  |  Atlantic: last row/last column  |
    - At conclusion of DFS searches from all ocean borders, iterate through the 
    initial array, approving squares that are reachable from both oceans
    
    Time: O(matrix), meaning you can reach the whole graph from both borders  
    Space: O(matrix)
    */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> results = new LinkedList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
        
        int rowLength = matrix.length; 
        int colLength = matrix[0].length;
        
        boolean[][] canReachPacific = new boolean[rowLength][colLength];
        boolean[][] canReachAtlantic = new boolean[rowLength][colLength];
        
        // DFS from Horizontal borders: Top Row (Pacific) & Bottom Row(Atlantic)
        for (int i = 0; i < colLength; i++) {
            dfs(matrix, canReachPacific, matrix[0][i], 0, i);
            dfs(matrix, canReachAtlantic, matrix[rowLength-1][i], rowLength-1, i);
        }
        
        
        // DFS from Vertical borders: Left Column (Pacific) & Right Column (Atlantic)
        for (int i = 0; i < rowLength; i++) {
            dfs(matrix, canReachPacific, matrix[i][0], i, 0);
            dfs(matrix, canReachAtlantic, matrix[i][colLength-1], i, colLength-1);
        }
        
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    ArrayList<Integer> validCell = new ArrayList<>();
                    validCell.add(i); validCell.add(j);
                    results.add(validCell);
                }
            }
        }
        
        return results;
    }
    
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void dfs(int[][] matrix, boolean[][] visited, int prevHeight, int row, int col ) {
        int rowLength = matrix.length; int colLength = matrix[0].length;
        
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || visited[row][col] || matrix[row][col] < prevHeight) {
            return;
        } else {
            visited[row][col] = true;
            
            for (int[] dir : directions) {
                dfs(matrix, visited, matrix[row][col], row + dir[0], col + dir[1]);
            }
        }
    }
}
