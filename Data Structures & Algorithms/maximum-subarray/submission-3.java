class Solution {
    public int maxSubArray(int[] nums) {
        

        int[] pre = new int[nums.length];
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            pre[i] = sum;
        }

        int minsum = Math.min(0, pre[0]);
        int maxans = pre[0];
        
        for(int i=1; i<nums.length; i++){
            int currsum = pre[i];
            maxans = Math.max(maxans, currsum - minsum);
            minsum = Math.min(minsum, currsum);
        }
        return (int)maxans;
    }
}
