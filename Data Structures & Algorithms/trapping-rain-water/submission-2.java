class Solution {
    public int trap(int[] height) {
        
        int i=0;
        int j=height.length - 1;
        int maxLeftLimiting = -1;
        int maxRightLimiting = -1;
        int ans = 0;

        while(i<=j){
            if(maxLeftLimiting<=maxRightLimiting){
                if(maxLeftLimiting-height[i]>0){
                    ans+=maxLeftLimiting-height[i];
                    System.out.println("check1");
                }
                maxLeftLimiting = Math.max(maxLeftLimiting, height[i]);
                System.out.println("ml " + maxLeftLimiting);
                i++;
            }
            else{
                if(maxRightLimiting-height[j]>0){
                    ans+=maxRightLimiting-height[j];
                    System.out.println("check2");
                }
                maxRightLimiting = Math.max(maxRightLimiting, height[j]);
                System.out.println("mr " + maxRightLimiting);
                j--;
            }
        }
        return ans;

    }
}
