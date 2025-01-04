//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int ans=0,size = arr.length;
        for(int i=0;i<size;i++){
            int j=i+1, k=size-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum<target){
                    j++;
                }
                else if(sum>target){
                    k--;
                }
                else {
                    int e1=arr[j], e2=arr[k], c1=0, c2=0;
                    while(j<=k && arr[j]==e1){
                        c1++;
                        j++;
                    }
                    
                    while(j<=k && arr[k]==e2){
                        c2++;
                        k--;
                    }
                    if(e1==e2){
                        ans+=(c1*(c1-1))/2;
                    }
                    else {
                        ans+=c1*c2;
                    }
                }
            }
        }
        return ans;
    }
}