package Java;

public class maxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int totalUnits = 0;
        int currCapacity = truckSize;
           
        int totalTypes = boxTypes.length;
        for (int i = totalTypes - 1; i >= 0; i--) {
            int numOfBoxes = boxTypes[i][0];
            int unitsPerBox = boxTypes[i][1];
            
            for (i = 0; i < numOfBoxes; i++) {
                if (currCapacity - unitsPerBox >= 0) {
                    numOfBoxes--; totalUnits++;
                    currCapacity -= unitsPerBox;
                } else {
                    break;
                }
            }   
        }
        return totalUnits;
    }
}
