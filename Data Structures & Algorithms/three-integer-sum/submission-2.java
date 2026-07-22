class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        int i=0;
        while(i<nums.length-2){
            int j = i+1;
            int k = nums.length - 1;

            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    list.add(List.of(nums[i], nums[j], nums[k]));
                    while(k>0 && nums[k-1]==nums[k]){
                        k--;
                    }
                    k--;
                    j++;
                }
                else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
            while((i < nums.length - 1) &&nums[i]==nums[i+1]){
                i++;
            }
            i++;
        }
        return list;
    }
}
