class Solution {
 public int missingNumber(int[] arr) {
        // code here
        Set<Integer> set=new LinkedHashSet<>();
        Arrays.sort(arr);
        int sum=0;
        for(int i:arr){
            if(i>0){
                set.add(i);
            }
        }
        int j=1;
        for(int i:set){
            if(j!=i) break;
            j++;
        }
        return j;        // code here
        
    }
}
