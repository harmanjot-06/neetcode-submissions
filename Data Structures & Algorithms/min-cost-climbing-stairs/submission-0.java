class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length<=1)return 0;
        int backcost = 0;
        int frontcost = 0;
        int currcost = 0;
        for(int i=2; i<cost.length + 1; i++){
            currcost = Math.min(backcost + cost[i-2], frontcost + cost[i-1]);
            backcost = frontcost;
            frontcost = currcost;
        } 
        return currcost;

    }
}
