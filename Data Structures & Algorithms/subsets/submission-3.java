class Solution {

    public List<List<Integer>> ans;

        public Solution(){
            this.ans = new ArrayList<>();
        }

    public void helper(int[] nums, int i, List<Integer> output){
        
        if(i>=nums.length){
            this.ans.add(new ArrayList<>(output));
            return;
        }

        helper(nums, i+1, output);
        output.add(nums[i]);
        helper(nums, i+1, output);
        output.remove(output.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return this.ans;
    }
}
