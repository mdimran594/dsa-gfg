//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
public int orangesRotting(int[][] mat) {
        // Code here
        
        Queue<int[]> queue = new LinkedList<>();
        
        int n=mat.length;
        int m=mat[0].length;
        int fresh=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2)
                queue.offer(new int[]{i,j});
                else if(mat[i][j]==1) fresh++;
            }
        }
        
        int[][] dir={{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        int time=0;
        
        //BFS
        while(!queue.isEmpty()){
            int size= queue.size();
            
            boolean anyRotten=false;
            
            for(int i=0;i<size;i++){
                int[] pos= queue.poll();
                
                int a=pos[0],b=pos[1];
                
                for(int[] d: dir ){
                    int ni=a + d[0];
                    int nj=b + d[1];
                    
                    if(ni>=0 && ni<n && nj>=0 && nj<m  &&  mat[ni][nj]==1){
                        mat[ni][nj]=2;
                        
                        fresh--;
                        queue.offer(new int[]{ni,nj});
                        anyRotten=true;
                    }
                }
                
            }if(anyRotten) time++;
        }
        return fresh==0 ? time: -1;        // Code here
        
        
    }
}