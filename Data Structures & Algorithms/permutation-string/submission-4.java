class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int mapcount = map.size();
        int l=0;
        int r=0;

        while(r<s2.length()){

            if(map.containsKey(s2.charAt(r))){
                map.put(s2.charAt(r), map.get(s2.charAt(r))-1);
                if(map.get(s2.charAt(r))==0)mapcount--;
            }

            if(r-l+1 < s1.length()){
                r++;
            }
            else if(r-l+1 == s1.length()){
                if(mapcount==0){
                    return true;
                }
                if(map.containsKey(s2.charAt(l))){
                    if(map.get(s2.charAt(l))==0)mapcount++;
                    map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                }
                l++;
                r++;
            }
        }
        return false;
    }
}
