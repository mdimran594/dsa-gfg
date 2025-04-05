//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
public int countIslands(char[][] grid) {
        // Code here
        int islands=0,n=grid.length,m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='L'){
                    floodFill(i,j,n,m,grid,vis,dir);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void floodFill(int i,int j,int n,int m,char grid[][],boolean vis[][],int dir[][]){
        if(i<0 || j<0 || i==n || j==m || vis[i][j] || grid[i][j]=='W') return;
        vis[i][j]=true;
        for(int[] d:dir) floodFill(i+d[0],j+d[1],n,m,grid,vis,dir);        // Code here
        
    }
}