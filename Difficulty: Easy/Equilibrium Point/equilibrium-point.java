//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int totalSum = 0; // To store the sum of all elements in the array
        int leftSum = 0;  // To store the sum of elements to the left of the current index

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Iterate through the array to find the equilibrium index
        for (int i = 0; i < arr.length; i++) {
            // Subtract the current element from totalSum to get the right sum
            totalSum -= arr[i];

            // Check if leftSum is equal to rightSum
            if (leftSum == totalSum) {
                return i; // Return the index as equilibrium point
            }

            // Update leftSum by adding the current element
            leftSum += arr[i];
        }

        return -1;
    }
}
