class Solution {
    /*
    Stack Solution
    Time: O(n) , Space: O(n)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        
        for (int num : nums2) {
            while (!s.isEmpty() && s.peek() < num) {
                hm.put(s.pop(), num);
            }
            s.push(num);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            if (hm.get(nums1[i]) != null) {
                nums1[i] = hm.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        
        return nums1;
    }
    
    /*
        Store index of each number in HashMap
        
        get index for int in nums1
        - search for next element >num1[index] in nums2
        - add (result) OR ("-1" if no result) answer array of nums1.length 
        
        Time: O(n^2) Space:(n)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // hm holds <key, value> = <element, its index within nums2> 
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n2Len = nums2.length;
        
        // save all index values of elements in num2
        for (int i = 0; i < n2Len; i++) {
            hm.put(nums2[i], i);
        }
        
        // find next great elements + track them in answer array
        int[] a = new int[nums1.length];
        for (int j = 0; j < a.length; j++) {
            int n1 = nums1[j]; // our "next greater element" is relative to this int from nums1
            int n2Index = hm.get(n1);
            int greater = -1;
            for (int k = n2Index + 1; k < n2Len; k++) {
                if (nums2[k] > n1) {
                    greater = nums2[k];
                    k = n2Len; // break out of for loop to prevent tracking other greater elements
                } 
            }
            a[j] = greater;
        }
        
        return a;
    }
}
