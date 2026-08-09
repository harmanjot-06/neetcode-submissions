class Solution {
    public boolean canJump(int[] nums) {
        
        int curr = 0;
        int nextmax = Integer.MIN_VALUE + 100;
        int steps = 0;

        while(curr<nums.length){
            if(curr>=nums.length-1)return true;
            int possjumps = Math.max(nextmax, nums[curr]);
            
            if(possjumps==0)return false;

            while(possjumps>0){
                curr++;
                if(curr>=nums.length-1)return true;
                nextmax--;
                nextmax = Math.max(nextmax, nums[curr]);
                possjumps--;
            }
            if(nextmax<=0)return false;
            steps++;

        }
        System.out.println(steps);
        return true;
    }
}
