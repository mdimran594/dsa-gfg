class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA == diffB) return b - a;
            return diffA - diffB;
        });

        for (int val : arr) {
            if (val != x) pq.offer(val);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
