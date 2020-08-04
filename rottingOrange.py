class Solution(object):
#     
#     Core idea: do BFS-search from initial rotten oranges
#         - Return -1 if there are remaining fresh oranges

#     How to do BFS? 
#     - Have local var for counting rounds of "rot-spreading"
#     - Push rotten oranges onto queue 1
#     - pop them off & put any "fresh neighbors" onto queue 2 (contaminated) + change their index element
#     - if any, add 1 to counter variable for "rounds"
#     - pop off queue 2, to add back to 1
#     
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        q1, q2 = [], []
        
        self.rowLen = len(grid)
        self.colLen = len(grid[0])
        
        self.fresh_oranges = 0
        
        for i in range(self.rowLen):
            for j in range(self.colLen):
                if grid[i][j] == 2:
                     q1.append((i, j))
                elif grid[i][j] == 1:
                    self.fresh_oranges += 1
                    
        if self.fresh_oranges == 0:
            return 0
        
        minutesElapsed = -1
        while (len(q1) > 0 or len(q2) > 0):
            if (len(q1) > 0):
                while (len(q1) > 0):
                    coord = q1.pop()
                    row = coord[0]
                    col = coord[1]
                    self.spreadRot(row, col, q2, grid)
                
            else: #q2 has things
                while (len(q2) > 0 ):
                    coord = q2.pop()
                    row = coord[0]
                    col = coord[1]
                    self.spreadRot(row, col, q1, grid)
            minutesElapsed += 1
        
        if self.fresh_oranges > 0:
            return -1
        
        return minutesElapsed
    
    
    def spreadRot(self, row, col, cleanQueue, grid):
        #change value + append
        if self.isValid(row+1, col, grid):
            cleanQueue.append((row+1, col))
            grid[row+1][col] = 2
            self.fresh_oranges -= 1
            
        if (self.isValid(row-1, col, grid)):
            cleanQueue.append((row-1, col))
            grid[row-1][col] = 2
            self.fresh_oranges -= 1
        
        if (self.isValid(row, col+1, grid)):
            cleanQueue.append((row, col+1))
            grid[row][col+1] = 2
            self.fresh_oranges -= 1
        
        if (self.isValid(row, col-1, grid)):
            cleanQueue.append((row, col-1))
            grid[row][col-1] = 2
            self.fresh_oranges -= 1
        
    def isValid(self, row, col, grid):
        return (row >= 0 and row < self.rowLen and col >= 0 and col < self.colLen and grid[row][col] == 1)
    
    
        
        
                        
        
