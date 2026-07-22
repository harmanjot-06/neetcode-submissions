class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        //[1, 2, 3, 4]
        //[2, 2, 4, 1]
        //[-1. 0, -1, +3]
        int maxposarrind = -1;
        int maxposs = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=gas.length-1; i>=0; i--){    
            sum+=gas[i]-cost[i];
            maxposs = Math.max(maxposs, gas[i]-cost[i]);
            if(maxposs == gas[i]-cost[i])maxposarrind = i;
        }
        
        if(sum<0)return -1;

        int i = maxposarrind;
        int sumgas = gas[i];
        int maxstartgas = gas[i];
        int ansind = i;
        int count = 1;
        while(count<gas.length){
            
            i = i-1;
            if(i==-1){
                i = gas.length-1;
            }
            sumgas = sumgas + gas[i]-cost[i];
            maxstartgas = Math.max(sumgas, maxstartgas);
            if(maxstartgas==sumgas)ansind = i;
            count++;
            
    }
    return ansind;

        //[+1, -2, +4, 0, -1, +5, -7, 0]

        //[1, 2, 3]
        //[2, 3, 2]
        //[-1, -1, +1]
    }
}
