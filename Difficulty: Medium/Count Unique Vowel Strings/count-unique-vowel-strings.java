class Solution {
public int vowelCount(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n= s.length();
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u')
            {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            
        }
        if(map.size() ==0)
        {
            return 0;
        }
            int x = map.size();
            int fact=1;
            while(x>0)
            {
                fact *=x;
                x--;
            }
            int temp=1;
            for(Map.Entry<Character, Integer> entry : map.entrySet())
            {
                temp *= entry.getValue();
            }
        return  (temp* fact);        // code here
        
    }
}