class Solution {
public boolean divby13(String s) {
      int j=1;
       String str=s.charAt(0)+"";
       int n=s.length();
       while(j<n) {
    	   str=str+s.charAt(j);
    	   int k=Integer.parseInt(str);
    	   str=(k%13)+"";
    	   j++;
       }
       return str.equals("0")?true:false;          // code here
        
    }
}