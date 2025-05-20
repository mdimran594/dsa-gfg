/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
   public static int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParents(root, parentMap, target);
        return burnTree(targetNode, parentMap);
    }
    
    private static Node mapParents(Node root, Map<Node, Node> parentMap, int target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.data == target){
                targetNode = current;
            }
            if(current.left != null){
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if(current.right != null){
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
        
        return targetNode;
    }
    
    private static int burnTree(Node targetNode, Map<Node, Node> parentMap){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean burned = false;
            
            for(int i=0; i<size; i++){
                Node current = queue.poll();
                for(Node neighbor : Arrays.asList(current.left, current.right, parentMap.get(current))){
                    if(neighbor != null && !visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                        burned = true;
                    }
                }
            }
            
            if(burned){
                time++;
            }
        }
        
        return time;
    }
}