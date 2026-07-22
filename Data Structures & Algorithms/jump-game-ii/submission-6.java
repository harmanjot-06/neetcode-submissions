class Solution {
    public int jump(int[] nums) {
        
        int i=0;
        int jumps = 0;
        if(nums.length==1)return 0;
        while(i<nums.length){
            jumps++;
            int maxnext = 0;
            if(i+nums[i]>=nums.length-1)return jumps;
            int maxindex = -1;
            for(int j=i+1; j<=i+nums[i]; j++){
                int finalval = nums[j] - (nums[i] - (j - i));
                maxnext = Math.max(maxnext, finalval);
                if(maxnext == finalval)maxindex = j;
            }
            i = maxindex;
        }

        return jumps;
        
    }
}
