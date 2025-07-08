class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int num : arr){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            int currentFreq = frequencyMap.get(arr[i]);
            
            while(!stack.isEmpty() && frequencyMap.get(stack.peek()) <= currentFreq){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                result.set(i, stack.peek());
            }
            
            stack.push(arr[i]);
        }
        
        return result;
    }
}