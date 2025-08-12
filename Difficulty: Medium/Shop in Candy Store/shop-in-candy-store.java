class Solution {
  public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int n = prices.length;
        Arrays.sort(prices);
        int minCost = 0, maxCost = 0;
        
        // Minimum cost calculation
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i];
            i++;
            j -= k; // get k most expensive free
        }
        
        // Maximum cost calculation
        i = 0; 
        j = n - 1;
        while (i <= j) {
            maxCost += prices[j];
            j--;
            i += k; // get k cheapest free
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;        // code here
        
    }
}
