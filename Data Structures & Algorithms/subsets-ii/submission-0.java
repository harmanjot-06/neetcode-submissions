class Solution {

    List<List<Integer>> ans;

    public void helper(int[] nums, int i, ArrayList<Integer> output){
        
        if(i<0){
            ans.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[i]);
        helper(nums, i-1, output);

        output.remove(output.size()-1);
        int nextIndex = i-1;
        while(nextIndex>=0 && nums[nextIndex]==nums[i]){
            nextIndex--;
        }
        helper(nums, nextIndex, output);
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        ans = new ArrayList<>();
        helper(nums, nums.length - 1, new ArrayList<>());
        return ans;
    }
}
