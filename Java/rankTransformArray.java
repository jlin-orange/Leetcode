class Solution {
    /* want to find out how large numbers are relative to one anotehr
     * Two approaches
     * 1. sort everything in array to find ranks, put ranks into dict, then correctly label original array
     * Time: O(n) Space: O(n)
     *
     *  2. For each num: count values (above/below) itself 
     *  Time: O(n^2) Space: O(1)
     */
    
    public int[] arrayRankTransform(int[] arr) {
        // creates copy of original array for sorting
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);
        
        // uses <key, rank> pairs
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // populate dict w/each # and its rank
        int rank = 1;
        for (int sortNum : sortArr) { 
            if (hm.get(sortNum) == null) {
                hm.put(sortNum, rank);
                rank++;
            }
        }
        
        // replace original array elements with rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = hm.get(arr[i]);
        }
        
        return arr;
    }
}
