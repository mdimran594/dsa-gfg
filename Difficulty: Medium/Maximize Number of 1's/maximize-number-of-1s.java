class Solution {
 public int maxOnes(int arr[], int k) {
        // code here
        int n=arr.length;
        
        int l=0;
        int cnt=0;
        int maxi=0;
        int val=k;
        for(int r=0;r<arr.length;r++){
            if(arr[r]==1){
                cnt++;
            }else if(k>0){
                cnt++;
                k--;
            }else{
                while(arr[l]==1 && l<r){
                    l++;
                    cnt--;
                }
                l++;
                
            }
            maxi=Math.max(cnt,maxi);
        }
        return maxi;        // code here
        
    }
}