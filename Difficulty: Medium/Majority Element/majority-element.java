//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int maxElem = -1, count = 1, max=0;
        if(n <= 1 || arr == null){
            return arr[0];
        }
        for(int i=0 ; i<n-1 ; i++){
            if(arr[i] == arr[i+1]){
                count = count + 1;
            }
            else{
                if(max <= count){
                    max = count;
                    maxElem = arr[i];
                }
                count = 1;
            }
        }
        if(max < count){
            max = count;
            maxElem = arr[n-1];
        }
        if(max > 1 && (max > n/2)) return maxElem;
        else return -1;
        
    }
}