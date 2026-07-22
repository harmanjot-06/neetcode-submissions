class Solution {

    public int find(int[] arr, int left, int right, int target){
        for(int i=left; i<=right; i++){
            if(arr[i]==target)return i;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {

       int left = 0;
       int right = nums.length-1;
       int start = -1;

       while(left<right){
        
        int mid = left + (right-left)/2;

        if(nums[mid] < nums[right]){
            right = mid;
        }
        else{
            left = mid + 1;
        }
       }
       start = left;

       if(target >= nums[start] && target <= nums[nums.length-1]){
        return find(nums, start, nums.length-1, target);
       }
        return find(nums, 0, start-1, target);
    }
}
