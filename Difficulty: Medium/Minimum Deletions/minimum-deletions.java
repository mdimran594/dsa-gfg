class Solution {
    static int minDeletions(String s) {
        // code here
         int n = s.length();
        return n - lcs(s, new StringBuilder(s).reverse().toString(), n);
    }
    
    static int lcs(String s1, String s2, int n) {
        int lcs[][] = new int[n + 1][n + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1;
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
                }
            }
        }
        
        return lcs[n][n];
    }
}