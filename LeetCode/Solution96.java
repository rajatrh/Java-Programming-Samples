class Solution96 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int sols = sol.numTrees(5);
        System.out.println(sols);
    }
}

class Solution {
    public int numTrees(int n) {
        return computeBST(n);
    }

    public int computeBST(int n) {
        if(n==0) return 0; 
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n; i++)
            for(int j=1; j<=i; j++)
                dp[i]+=dp[j-1]*dp[i-j];
        
        return dp[n];
    } 
}