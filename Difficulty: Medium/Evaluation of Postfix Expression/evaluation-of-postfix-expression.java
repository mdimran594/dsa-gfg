//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
          Stack<Integer> s = new Stack<>();
        
        for(String c : arr){
            char p = c.charAt(c.length()-1);
            if(Character.isDigit(p)){
                int x = Integer.parseInt(c);
                s.push(x);
            }else{
                int a = s.pop();
                int b = s.pop();
                if(p=='+'){
                    s.push(b+a);
                }else if(p=='-'){
                    s.push(b-a);
                }else if(p=='*'){
                    s.push(b*a);
                }else{
                    s.push(b/a);
                }
            }
        }
        return s.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends