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

        int nextIndex = i-1;
        if(i!=0){
            while(nextIndex>=0 && nums[i]==nums[nextIndex]){
                nextIndex--;
            }
        }

        if(nums[i]<=target){
            output.add(nums[i]);
            helper(nums, i-1, target - nums[i], output);
            output.remove(output.size()-1);
            helper(nums, nextIndex, target, output);
        }
        else{
            helper(nums, nextIndex, target, output);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, candidates.length - 1, target, new ArrayList<>());
        return ans;
    }
}
