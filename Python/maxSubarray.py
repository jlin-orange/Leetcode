#div n' conquer 
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def RMPS(a, R_index):
            rmps = a[R_index]
            result = a[R_index]
            for i in range(R_index - 1, 0, -1):
                result += a[i]
                rmps = max(result, rmps)
                    
            return rmps
        
        def LMPS(a, L_index):
            lmps = a[L_index]
            result = a[L_index]
            for i in range(L_index, len(nums)):
                result += a[i]
                lmps = max(result, lmps)
                    
            return lmps
                
        
        def MPS(A, i ,j):
            if (i == j):
                return A[i]
            print(i,j)
            mid = int(floor((i+j)/2))
            
            LHMPS = MPS(A, i, mid)
            RHMPS = MPS(A, mid+1, j)
            straddle = RMPS(A, mid) + LMPS(A, mid+1)

            print("LH: " + str(LHMPS) + "  RH: " + str(RHMPS) + "   Straddle: " + str(straddle))
            return max(LHMPS, straddle, RHMPS);    
        
        return MPS(nums, 0, len(nums)-1)
            
        
