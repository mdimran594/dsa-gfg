class Solution {
 public boolean isPossible(int [] arr,int k,int w,int mid){
        //since array issent by reference we don't want to make changes 
        //the original array we create a copy of array as flloows
        int [] flowers=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            flowers[i]=arr[i];
        }
        
        //now perform operations using copy array
        for(int i=0;i<flowers.length;i++){
            if(flowers[i]<mid){
                //we should add some 'value ' to make it equal to mid
                int value =mid-flowers[i]; //eg: arr[i]=1,mid==2, so to make arr[i]==mid, we should add 1 , (mid-arr[i])
                //check if the value if exceeding no. of days 'k'
                if(value>k){
                    return false;
                }
                //since we added some 'value ' it means 1 value =1 day, so remove 'value' from no. of days 'k'
                k-=value;
                //peform same for 'w' continuous flowers
                for(int j=i;j<flowers.length;j++){
                    if(j<i+w)
                    flowers[j]+=value;
                }
                
            }
            
        }
        return true;
    }
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int mn=Integer.MAX_VALUE;
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++)
            mn=Math.min(arr[i],mn);
        int low=mn,high=mn+k;
        
            //as we are supposed to water the least height flower 
            // so min(arr) gives least height flower and min+k means 
            //watering the least height flower for 'k' days
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if(isPossible(arr,k,w,mid)){
                    //as we are supposed to find the maximum height
                    //we move right side for oppotunties 
                    // if the flower can go that particular 'mid' height or not
                    ans=mid;
                    low=mid+1;
                }
                else {
                    //move left
                    high=mid-1;
                }
            }
            return ans;        // code here
        
    }
}