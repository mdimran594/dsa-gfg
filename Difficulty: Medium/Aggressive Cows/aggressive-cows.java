//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean isPos(int[] a,int k,int minDis){
        int number=1;
        int last=a[0];
        
        for(int i=1;i<a.length;i++){
            if(a[i]-last >= minDis){
                number++;
                last=a[i];
            }
            if(number >= k)
                return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
         int ans=0;
        Arrays.sort(stalls);
        
        int n=stalls.length;
        int l=1;
        int h=stalls[n-1]-stalls[0];
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPos(stalls,k,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
            
        }
        
        return ans;
    }
}