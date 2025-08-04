class Solution {
public int maxRectSum(int arr[][]) {
        // code here
        int n =arr.length;
        int m =  arr[0].length;
         int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < m; left++) {
            // Temp array to store row sums
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                // Add current column to each row
                for (int i = 0; i < n; i++) {
                    temp[i] += arr[i][right];
                }
                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }
     private static int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;        // code here
        
    }
};