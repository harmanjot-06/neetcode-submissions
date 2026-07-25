class Solution {
    public int climbStairs(int n) {
        
        int forn1 = 1;
        int forn2 = 2;

        if(n==1)return 1;
        if(n==2)return 2;
        int currans = 0;

        for(int i=3; i<=n; i++){
            currans = forn1 + forn2;
            forn1 = forn2;
            forn2 = currans;
        }
        return currans;
    }
}
