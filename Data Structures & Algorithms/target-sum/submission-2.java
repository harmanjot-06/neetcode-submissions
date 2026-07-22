class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(target>sum || target<-sum)return 0;
        //max positive target -> sum max negative target-> -sum
        //our target index -> sum+target
    
        int[][] dp = new int[nums.length+1][2*sum+1];

        for(int j=1; j<=2*sum; j++){
            dp[0][j] = 0;
        }
        dp[0][sum] = 1;

        for(int i = 1; i<=nums.length; i++){
            for(int j = 0; j<=2*sum; j++){
                int combs = 0;
                int currtarget = -sum + j;
                int newtarget;
                //num positive
                newtarget = currtarget - nums[i-1];
                if(Math.abs(newtarget)<=sum){
                    combs += dp[i-1][sum + newtarget];
                }
                //num negative
                newtarget = currtarget + nums[i-1];
                if(Math.abs(newtarget)<=sum){
                    combs += dp[i-1][sum + newtarget];
                }
                dp[i][j] = combs;
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        return dp[nums.length][sum+target];

    }
}
