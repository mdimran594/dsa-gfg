//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    // Method to perform boundary traversal of a binary tree
    ArrayList<Integer> boundaryTraversal(Node node) {
        // Initialize the result list
        ArrayList<Integer> ans = new ArrayList<>();
        
        // If the tree is empty, return null
        if (node == null) return null;
        
        // Add the root node to the result if it's not a leaf node
        if (!leaf(node)) {
            ans.add(node.data);
        }
        
        // Traverse the left boundary (excluding leaf nodes)
        left(node, ans);
        
        // Add all the leaf nodes
        addleaves(node, ans);
        
        // Traverse the right boundary (excluding leaf nodes) in reverse order
        right(node, ans);
        
        // Return the final result
        return ans;
    }
    
    // Helper method to check if a node is a leaf node
    public static boolean leaf(Node node) {
        return (node.left == null && node.right == null);
    }
    
    // Method to traverse the left boundary of the tree
    void left(Node root, ArrayList<Integer> ans) {
        Node curr = root.left;
        
        // Traverse the left boundary
        while (curr != null) {
            // If the current node is not a leaf, add it to the result
            if (!leaf(curr)) {
                ans.add(curr.data);
            }
            // Move to the left child if it exists, otherwise move to the right child
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    
    // Method to traverse the right boundary of the tree in reverse order
    void right(Node root, ArrayList<Integer> ans) {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        
        // Traverse the right boundary
        while (curr != null) {
            // If the current node is not a leaf, push it to the stack
            if (!leaf(curr)) {
                st.push(curr.data);
            }
            // Move to the right child if it exists, otherwise move to the left child
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        
        // Pop elements from the stack and add them to the result (to get reverse order)
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
    }
    
    // Method to add all leaf nodes to the result
    void addleaves(Node root, ArrayList<Integer> ans) {
        // Base case: if the node is null, return
        if (root == null) return;
        
        // If the node is a leaf, add it to the result
        if (leaf(root)) {
            ans.add(root.data);
        } else {
            // Recursively add leaves from the left and right subtrees
            addleaves(root.left, ans);
            addleaves(root.right, ans);
        }
    }
}
