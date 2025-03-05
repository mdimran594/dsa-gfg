//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        // code here
         Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> dp = new HashMap<>(); // Stores longest chain ending at word
        int maxLength = 1;

        for (String word : words) {
            dp.put(word, 1); // Initialize chain length as 1

            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1); // Remove 1 char

                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }

            maxLength = Math.max(maxLength, dp.get(word));
        }

        return maxLength;
        
    }
}