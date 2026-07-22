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

        Collections.sort(list, (row1, row2) -> {
            Integer value1 = row1.get(1);
            Integer value2 = row2.get(1);
            return value2.compareTo(value1);
        });

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = list.get(i).get(0);
        }
        return ans;

    }
}
