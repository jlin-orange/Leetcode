class Solution {
    /*
    Make a max heap of the stones before greedily smashing the 
    2 heaviest stones + updating the heap afterwards until there
    is >=1 stone left.
    
    Use a priority queue to implement a max heap.
    Loop to add all elemenets of stones to heap.
    Take 2 largest stones, "smash them", then re-insert remainder stone (if there is one)
    
    Time: O(nlgn) - heapifying (both upon intial insertion/re-insertion of remainder stones)
    Space: O(n) - heap must be contain all stones
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

        int lastStone = stoneMaxHeap.peek() == null ? 0 : stoneMaxHeap.poll();
        return lastStone;
    }
}
