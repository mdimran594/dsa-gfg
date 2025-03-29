//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

class pair implements Comparable<pair>{
		int x;
		int y;
		
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(pair o) {
			return o.y-this.y;
		}
	}

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int size=0;
        for(int a: deadline)size=Math.max(a, size);   	
        int maxday[]=new int[size+1];
        
        pair arr[]=new pair[deadline.length];
        
        for(int i=0;i<deadline.length;i++) 
        	arr[i]=new pair(deadline[i], profit[i]);
        
        Arrays.sort(arr);
    
        
        int ind=1;
        int maxProfit=arr[0].y;
        int noOfJob=1;
        maxday[arr[0].x]=1;
        while(ind<deadline.length) {
        	int k=arr[ind].x;
        	for(int j=k;j>0;j--) {
        		if(maxday[j]!=1) {
        			maxday[j]=1;
        			noOfJob++;
        			maxProfit+=arr[ind].y;
        			break;
        		}
        	}
        	ind++;
        }
        
    	ArrayList<Integer> ans=new ArrayList<>();
    	ans.add(noOfJob);
    	ans.add(maxProfit);
    	return ans;        // code here
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends