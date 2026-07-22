class Solution {
    public int change(int amount, int[] coins) {
        
        Arrays.sort(coins);
        int[][] dp = new int[coins.length+1][amount+1];

        for(int j = 1; j<=amount; j++){
            dp[0][amount] = 0;
        }
        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                int combs = 0;
                int newamount = j - coins[i-1];
                if(newamount>=0){
                    combs+=dp[i][newamount];
                }
                combs+=dp[i-1][j];
                dp[i][j] = combs;
            }
        }

        return dp[coins.length][amount];


    }
}
