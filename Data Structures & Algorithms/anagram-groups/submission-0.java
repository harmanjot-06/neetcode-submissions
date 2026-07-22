class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<Integer>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            Map<Character, Integer> stringMap = new HashMap<>();
            for(int j=0; j<strs[i].length(); j++){
                stringMap.put(strs[i].charAt(j), 
                stringMap.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            List<Integer> temp = map.getOrDefault(stringMap, new ArrayList<Integer>());
            temp.add(i);
            map.put(stringMap, temp);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Map<Character, Integer>, List<Integer>> entry : map.entrySet()){
            List<String> temp = new ArrayList<>();
            for(Integer i : entry.getValue()){
                temp.add(strs[i]);
            }
            ans.add(temp);
        }

        return ans;
    }
}

