//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            // Read the array from input line
            String inputLine = read.readLine().trim();
            String[] inputArr = inputLine.split("\\s+");
            int n = inputArr.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findDuplicate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
 public int findDuplicate(int[] arr) {
        if (arr.length == 2) return arr[0];

        int n = arr.length - 1;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int) (actualSum - expectedSum);        // code here
        
    }
}