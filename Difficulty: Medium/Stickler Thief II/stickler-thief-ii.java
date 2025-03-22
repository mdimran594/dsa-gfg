//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
 int maxValue(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Consider houses from index 0 to n-2
        int prev2 = 0, prev = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int take = nums[i] + (i > 1 ? prev2 : 0);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        int max1 = prev;

        // Case 2: Consider houses from index 1 to n-1
        prev2 = 0;
        prev = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + (i > 2 ? prev2 : 0);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        int max2 = prev;

        return Math.max(max1, max2);        // code here
        
    }
}
