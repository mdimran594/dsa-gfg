class Solution {
private void init(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=-1;
            }
        }
    }
    private void print(int[][] arr){
        for(int it[]:arr){
            for(int i:it){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
    public ArrayList<Integer> asciirange(String s) {
        int n=s.length();
        int[][] map=new int[26][2];
        init(map);
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'a';
            //First Occurrence
            if(map[ch][0]==-1){
                map[ch][0]=i;
            }
            //Last Occurrence
            map[ch][1]=i;
        }
        //print(map);
        int[] prefix=new int[n];
        prefix[0]=(s.charAt(0)-'a')+97;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(s.charAt(i)-'a')+97;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(map[i][0]!=-1){
                int sum=prefix[map[i][1]]-prefix[map[i][0]]-(i+97);
                if(sum>0){
                    ans.add(sum);
                }
            }
        }
        return ans;        // code here
        
    }
}