class Solution {
    /*
    Distance Array Key 
    Ex: [a,b,c]
    a = distance from 0->1
    b = distance from 1->2
    c = distance from 2->0
    
    case 1: start < destination 
    - c: iterate forwards to dest
    - ccw: iterate backwards to front of array then restart @ back
    
    case 2: start > destination
    - c: iterate to end of array then restart @ front
    - ccw: iterate backwards to dest
    
    Time: O(n) , Space: O(1)
    */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        
        System.out.println(distance.length);
        
        // Clockwise Distance
        int cDist = 0;
        
        // Counter-Clockwise Distance
        int ccwDist = 0;
        
        // when start is BEFORE destination 
        if (destination < start) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        
        // calc clockwise dist
        for (int i = start; i < destination; i++) {
            cDist += distance[i];
        }

        // calc COUNTER-clockwise dist
        for (int j = start-1; j != destination-1; j--) {
            if (j < 0) {
                j = distance.length;
            } else {
                ccwDist += distance[j];
            }
        }
        
        return Math.min(cDist, ccwDist);
    }
}
