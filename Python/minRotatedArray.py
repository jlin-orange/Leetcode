class Solution(object):
    # Space: O(1) Time: O(lgn)
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums[0] < nums[-1]: # order is unchanged
            return nums[0]
        else:
            return self.binSearch(nums, nums[0])
            
    #if > num[0] -> right
    #if < nums[0] -> left  
    def binSearch(self, nums, anchor):
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return min(nums[0], nums[1])
        else: 
            mid = len(nums)/2
            # print(mid)
            if nums[mid] > anchor:            
                return self.binSearch(nums[mid:], anchor)
            else: # nums[mid] < anchor
                return self.binSearch(nums[:mid+1], anchor)
        
        
        
