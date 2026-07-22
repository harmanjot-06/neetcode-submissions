class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int l = 0;
        int r = 0;
        int min = prices[l];
        int ans = 0;

        while(r<prices.length){
            if(l==r){
                r++;
                continue;
            }
            if(prices[r] < prices[l]){
                l=r;
                continue;
            }
            ans = Math.max(ans, prices[r]-prices[l]);
            r++;
        }
        return ans;
    }
}
