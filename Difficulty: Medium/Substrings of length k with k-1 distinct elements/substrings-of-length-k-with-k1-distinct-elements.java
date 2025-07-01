class Solution {
 int findCnt(int chr[]){
       int cnt=0;
       for(int a: chr)if(a!=0)cnt++;
       return cnt;
    }
    
    public int substrCount(String s, int k) {
         int i=0;
         int j=0;
         int n=s.length();
         int ch[]=new int[26];
         int cnt=0;
         while(j<n){
             char chr=s.charAt(j);
             ch[chr-'a']++;
             if(j-i+1<k){
                j++;
             }else if(j-i+1==k){
                 if(findCnt(ch)==k-1)cnt++;
                 j++;
             }else {
                 char temp=s.charAt(i);
                 ch[temp-'a']--;
                 if(findCnt(ch)==k-1)cnt++;
                 i++;
                 j++;
             }
         }
         return cnt;        // code here
        
    }
}