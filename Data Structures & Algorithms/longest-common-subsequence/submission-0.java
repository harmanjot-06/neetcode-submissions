class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        for(int j=0; j<n+1; j++){
            dp[0][j] = 0;
        }
        for(int i=0; i<m+1; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                int op1 = -1;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    op1 = 1 + dp[i-1][j-1];
                }
                int op2 = dp[i][j-1];
                int op3 = dp[i-1][j];
                dp[i][j] = Math.max(op1, Math.max(op2, op3));
            }
        }

        return dp[m][n];
    }
}
