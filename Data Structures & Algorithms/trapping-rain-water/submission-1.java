class Solution {
    public int trap(int[] height) {
        
        int[] largestLeft = new int[height.length];
        int[] largestRight = new int[height.length];

        int maxleft = -1;
        int maxright = -1;

        for(int i=0; i<height.length; i++){
            if(i==0){
                largestLeft[i] = -1;
                largestRight[height.length-i-1] = -1;
                maxleft = height[i];
                maxright = height[height.length-i-1];
                continue;
            }
            largestLeft[i] = maxleft;
            maxleft = Math.max(maxleft, height[i]);
            largestRight[height.length-i-1] = maxright;
            maxright = Math.max(maxright, height[height.length-i-1]);
        }

        int ans = 0;
        for(int i=1; i<height.length-1; i++){
            if(Math.min(largestLeft[i], largestRight[i]) <= height[i]){
                continue;
            }
            ans+=(Math.min(largestLeft[i], largestRight[i]) - height[i]);
        }
        return ans;

    }
}
