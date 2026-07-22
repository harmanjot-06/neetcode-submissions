class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int maxlength = 0;

        while(j<=s.length()-1){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), j);
                System.out.println(j-i+1);
                maxlength = Math.max(maxlength, j-i+1);
                j++;
            }
            else{
                int repfoundindex = map.get(s.charAt(j));
                while(i <= repfoundindex){
                    map.remove(s.charAt(i));
                    i++;
                }
                map.put(s.charAt(j), j);
                j++;
            }
        }
        return maxlength;
    }
}
