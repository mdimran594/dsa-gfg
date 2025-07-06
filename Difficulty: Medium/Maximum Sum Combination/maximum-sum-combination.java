class Pair{
    int first;
    int second;
    
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        
        Pair p = (Pair)o;
        
        if(p.first == this.first && p.second == this.second)
            return true;
        return false;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.first, this.second);
    }
}

class Node{
    int val;
    Pair pair;
    
    Node(Pair p, int v){
        this.val = v;
        this.pair = p;
    }
}

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        
        int i, j;
        
        int n = a.length;
        
        Set<Pair> vis = new HashSet();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        i = n-1;
        j = n-1;
        
        PriorityQueue<Node> q = new PriorityQueue<>((y, z) ->{
            return (z.val - y.val);
        });
        
        q.add(new Node(new Pair(i, j), a[i] + b[j]));
        // vis.add(new Pair(i, j));
        
        // System.out.println(q.peek().val);
        
        while(k > 0){
            // System.out.println(q.size());
            Node curr = q.poll();
            int val = curr.val;
            Pair pair = curr.pair;
            
            // System.out.println(val);
            
            if(vis.contains(pair))
                continue;
            
            ans.add(val);
            vis.add(pair);
            
            int ind1 = pair.first;
            int ind2 = pair.second;
            
            if(ind1-1 >= 0){
                q.add(new Node(new Pair(ind1-1, ind2), a[ind1-1] + b[ind2]));
            }
            
            if(ind2-1 >= 0){
                q.add(new Node(new Pair(ind1, ind2-1), a[ind1] + b[ind2-1]));
            }
            
            k -= 1;
        }
        
        
        return ans;       
    }
}