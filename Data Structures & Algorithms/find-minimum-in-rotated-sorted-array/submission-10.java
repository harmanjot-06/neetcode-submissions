class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            
            if(left==right)return nums[left];
            if(right-left==1)return Math.min(nums[left], nums[right]);
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])return nums[mid];

            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }

        return -1;
    }
}
