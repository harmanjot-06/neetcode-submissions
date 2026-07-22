class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for(int k = 0; k<nums.length; k++){
            int i=0;
            int j=nums.length - 1;
            while(i<j){
                if(i==k){
                    i++;
                    continue;
                }
                if(j==k){
                    j--;
                    continue;
                }

                if(nums[i] + nums[j] + nums[k] == 0){
                    
                    int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                    int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                    int mid = 0 - min - max;
                    set.add(List.of(min, mid, max));
                    i++;
                    j--;
                }
                else if(nums[i] + nums[j] + nums[k] < 0){
                    i++;
                }
                else{
                    j--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> list : set){
            ans.add(list);
        }

        return ans;

    }
}