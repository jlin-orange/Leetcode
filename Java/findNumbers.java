package Java;

/*
Iterate through an array to check the number of digits in each number
and tallying the total count of even digit numbers accordingly!

Time: O(number of digits in the array) 
Space: O(num.length) where num.length = the maximum number of digits in any number from the array 
*/
public class findNumbers {
    public int findEvenDigitNums(int[] nums) {
        int totalEven = 0;
        
        for (int num : nums) {
            if(findNumOfDigits(num, 0) % 2 == 0) totalEven++;
        }
        return totalEven;
    }
    
    // Recursively find the num of digits in a number by repeatedly dividing over 10
    public int findNumOfDigits(int currValue, int totalDigits) {
        int newValue = currValue/10;
        if (newValue == 0) return ++totalDigits;
        
        return findNumOfDigits(newValue, ++totalDigits);
    }
}
