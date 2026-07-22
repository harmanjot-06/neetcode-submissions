class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new ArrayList<>(Arrays.asList(entry.getKey(), entry.getValue())));
        }

        list.sort((row1, row2) -> {return row2.get(1) - row1.get(1);});

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = list.get(i).get(0);
        }
        return ans;

    }
}
