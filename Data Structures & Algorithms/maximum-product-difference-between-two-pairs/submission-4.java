class Solution {
    public int maxProductDifference(int[] a) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE, 
            largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            }
            else if (a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            }  
            else if (a[i] > secondLargest) {
                secondLargest = a[i];
            }
        }

        return largest * secondLargest - smallest * secondSmallest;
    }
}