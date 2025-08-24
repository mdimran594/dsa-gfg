class Solution {
private boolean canMake(int[] arr, int k, int m, int day) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int bloom : arr) {
            if (bloom <= day) { // flower has bloomed
                flowers++;
                if (flowers == k) { // we have enough for a bouquet
                    bouquets++;
                    flowers = 0; // reset for next bouquet
                }
            } else {
                flowers = 0; // reset consecutive flowers
            }
        }
        return bouquets >= m;
    }
    
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        if (n < m * k) return -1; // not enough flowers
        
        int low = 1;
        int high = 0;
        for (int bloom : arr) {
            high = Math.max(high, bloom); // maximum bloom day
        }
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, k, m, mid)) {
                ans = mid;
                high = mid - 1; // try to find smaller day
            } else {
                low = mid + 1;
            }
        }
        return ans;        // code here
        
    }
}