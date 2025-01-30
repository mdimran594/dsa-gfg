//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), solutions);
        return solutions;
    }

    private void backtrack(int n, int col, ArrayList<Integer> queenPositions, ArrayList<ArrayList<Integer>> solutions) {
        if (col == n) {
            solutions.add(new ArrayList<>(queenPositions));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (isSafe(queenPositions, row, col)) {
                queenPositions.add(row);
                backtrack(n, col + 1, queenPositions, solutions);
                queenPositions.remove(queenPositions.size() - 1);
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> queenPositions, int newRow, int newCol) {
        for (int col = 0; col < queenPositions.size(); col++) {
            int row = queenPositions.get(col);
            if (row == newRow || Math.abs(row - newRow) == Math.abs(col - newCol)) {
                return false;
            }
        }
        return true;
    }
}