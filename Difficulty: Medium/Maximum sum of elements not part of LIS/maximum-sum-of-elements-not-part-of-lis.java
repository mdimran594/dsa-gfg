class Solution {
public int nonLisMaxSum(int[] arr) {
        int n = arr.length;

        // Arrays to store:
        // lisLen[i] = length of LIS ending at i
        // lisSum[i] = sum of that LIS
        int[] lisLen = new int[n];
        int[] lisSum = new int[n];

        // Initialize each position with length 1 and sum = arr[i]
        for (int i = 0; i < n; i++) {
            lisLen[i] = 1;
            lisSum[i] = arr[i];
        }

        // DP to fill lisLen and lisSum
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lisLen[j] + 1 > lisLen[i]) {
                        // Longer LIS found
                        lisLen[i] = lisLen[j] + 1;
                        lisSum[i] = lisSum[j] + arr[i];
                    } else if (lisLen[j] + 1 == lisLen[i]) {
                        // Same length, choose smaller sum
                        lisSum[i] = Math.min(lisSum[i], lisSum[j] + arr[i]);
                    }
                }
            }
        }

        // Step 1: Find max length of LIS
        int maxLen = 0;
        for (int len : lisLen) {
            maxLen = Math.max(maxLen, len);
        }

        // Step 2: Among all LIS of maxLen, find one with min sum
        int minLISsum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (lisLen[i] == maxLen) {
                minLISsum = Math.min(minLISsum, lisSum[i]);
            }
        }

        // Step 3: Total sum of array
        int totalSum = 0;
        for (int val : arr) totalSum += val;

        // Step 4: Answer = total - lisSum
        return totalSum - minLISsum;        // code here
        
    }
}