class Solution {

    public int helper(int[] nums, int start, int end){
        
        int dp[] = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i<=end; i++){
            dp[i-start] = Math.max(nums[i] + dp[i-start-2], dp[i-start-1]);
        }
        return dp[dp.length-1];
    }

    public int rob(int[] nums) {
        
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0], nums[1]);
        if(nums.length==3)return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int a = helper(nums, 0, nums.length-2);
        int b = helper(nums, 1, nums.length-1);
        return Math.max(a,b);
    }
}
