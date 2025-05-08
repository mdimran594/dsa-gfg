//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n = arr.length;
        int diff = (arr[1]-arr[0])<(arr[n-1]-arr[n-2])?(arr[1]-arr[0]):(arr[n-1]-arr[n-2]);
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int expected = arr[0] + diff*mid;
            if(arr[mid] == expected){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return arr[0]+left*diff;
        
    }
}
