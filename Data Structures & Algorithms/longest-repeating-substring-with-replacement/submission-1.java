class Solution {

    public int helper(Map<Character, Integer> map){
        int max = 0;
        for(int freq : map.values()){
            max = Math.max(max, freq);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        
        int l=0;
        int r=0;
        int maxf=0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(r<s.length()){

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));

            if(r-l+1-maxf <= k){
                ans = Math.max(ans, r-l+1);
                r++;
            }
            else{
                while(r-l+1-maxf > k){
                    map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                    l++;
                    maxf = Math.max(maxf, map.get(s.charAt(r)));
                }
                r++;
            }
        }
        return ans;
        
    }
}
