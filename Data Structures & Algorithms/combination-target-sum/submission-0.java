class Solution {

    List<List<Integer>> ans;
    
    public void helper(int[] nums, int i, int target, ArrayList<Integer> output){


        if(target==0){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(i<0){
            return;
        }

        if(nums[i]<=target){
            output.add(nums[i]);
            helper(nums, i, target - nums[i], output);
            output.remove(output.size()-1);
            helper(nums, i-1, target, output);
        }
        else{
            helper(nums, i-1, target, output);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, nums.length - 1, target, new ArrayList<>());
        return ans;
    }
}
