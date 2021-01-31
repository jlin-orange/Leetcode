package Java;

public class mergeSortedArray {
    // 2 pointers to compare elements from each array!
    // - start from index m, n in each array respectively!
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        
        int targetIndex = m + n - 1; // starts at end of nums1
        
        // Procedurally compare biggest numbers from nums1[ptr1], nums2[ptr2]
        while (ptr1 >= 0 && ptr2 >= 0) {    
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[targetIndex] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[targetIndex] = nums2[ptr2];
                ptr2--;
            }
            targetIndex--;
        }
        
        if (ptr1 < 0) {
            while (ptr2 >= 0) {
                nums1[targetIndex] = nums2[ptr2];
                ptr2--;
                targetIndex--;
            }
        } else {
            while (ptr1 >= 0) {
                System.out.println(targetIndex);
                nums1[targetIndex] = nums1[ptr1];
                ptr1--;
                targetIndex--;
            }
        }
    }
}
