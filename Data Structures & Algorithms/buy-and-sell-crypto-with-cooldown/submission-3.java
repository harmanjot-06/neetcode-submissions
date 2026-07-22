class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[prices.length+1][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        
        for(int i=1; i<=prices.length; i++){

            dp[i][0] = dp[i-1][3] - prices[i-1];
            if(i==1){
                dp[i][1] = Integer.MIN_VALUE;
            }
            else{
                dp[i][1] = Math.max(prices[i-1] + dp[i-1][0], prices[i-1] + dp[i-1][2]);
            }
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][2]);
            if(i==1){
                dp[i][2] = Integer.MIN_VALUE;
            }
            dp[i][3] = Math.max(dp[i-1][1], dp[i-1][3]);            
        }

        return Math.max(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]), dp[n][3]);
    }
}
