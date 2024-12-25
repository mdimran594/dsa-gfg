//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        ArrayList<Integer> rows=new ArrayList<>();
        ArrayList<Integer> cols=new ArrayList<>();
        
        int r=mat.length;
        int c=mat[0].length;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(mat[i][j]==0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        //MAKING ALL ELEMENTS OF ROWS = 0 
        //Traversing through columns to make row = 0
        for(int row:rows)
        {
            for(int j=0;j<c;j++)
            {
                mat[row][j]=0;
            }
        }
        
        //MAKING ALL ELEMENTS OF COLUMNS = 0
        //Traversing through rows to make columns = 0
        for(int col: cols)
        {
            for(int i=0;i<r;i++)
            {
                mat[i][col]=0;
            }
        }
    }
}