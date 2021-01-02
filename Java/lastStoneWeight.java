class Solution {
    /*
    Gist: Make a max heap of the stones before greedily smashing the 
    2 heaviest stones. Always update the heap afterwards until there
    is x<=1 stone left.
    
    Steps
    1.Use a priority queue to implement a max heap.
    2. Loop to add all elements of stones to heap.
    3. While heap has >1 stones, 
        take 2 largest stones, "smash them", then re-insert remainder stone (if there is one)
    4. Return final stone (if exists)
    
    Time: O(nlgn) - heapifying (both upon intial insertion/re-insertion of remainder stones)
    Space: O(n) - heap must contain all stones
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Heapify stones
        for (int stone : stones) {
            stoneMaxHeap.add(stone);
        }

        while (stoneMaxHeap.size() > 1) {
            int firstStone = stoneMaxHeap.poll();
            int secondStone = stoneMaxHeap.poll();

            int remainder = firstStone - secondStone;
            if (remainder > 0) {
                stoneMaxHeap.add(remainder);
            } 
        }

        int lastStone = stoneMaxHeap.isEmpty() ? 0 : stoneMaxHeap.poll();
        return lastStone;
    }
}
