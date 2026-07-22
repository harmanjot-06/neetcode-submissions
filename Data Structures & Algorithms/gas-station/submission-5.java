class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalsum=0;
        int sum = 0;
        int startindex = 0;
        // int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<gas.length; i++){
            totalsum+=gas[i] - cost[i];
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                startindex=i+1;
            }
        }
        if(totalsum<0)return -1;
        return startindex;
    }
}
