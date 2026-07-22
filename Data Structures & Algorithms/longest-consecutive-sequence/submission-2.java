class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, 1);
        }

        int maxlcs = 1;

        for(int num : map.keySet()){
            if(map.containsKey(num-1)){
                continue;
            }
            int counter = num;
            int lcs = 1;
            while(map.containsKey(counter+1)){
                lcs+=1;
                counter++;
            }
            maxlcs = Math.max(lcs, maxlcs);
        }

        return maxlcs;
    }
}
