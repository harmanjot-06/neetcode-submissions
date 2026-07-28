class Solution {

    public int helper(HashMap<Character, Integer> map){
        int ans = 0;
        for(Integer i : map.values()){
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public int characterReplacement(String s, int k) {
        // longest substring where length of substring - freq of most freqent char <= k

        HashMap<Character, Integer> map = new HashMap<>();

        int i=0;
        int j = 0;
        int ans = 1;

        while(i<s.length() && j<s.length()){

            char ch = s.charAt(j);
            int sublen = j-i+1;

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            int freq = helper(map);
            if(sublen - freq<=k){ 
                ans = Math.max(ans, sublen);
                j++;
            }
            else{
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if(map.get(s.charAt(i))==0)map.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return ans;
    }
}
