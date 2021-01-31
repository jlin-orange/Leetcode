package Java;

public class dupZero {
    public void duplicateZeros(int[] arr) {
        boolean needsDup = false;
        for (int i = 0; i < arr.length; i++) {
            if (needsDup == false) {
                if (arr[i] == 0) {
                    needsDup = true;
                }
            } else if (needsDup == true) { 
                // Shift over elements in array - O(n)
                for (int j = arr.length-1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i] = 0;
                needsDup = false;
                
            }
        }
    }
}
