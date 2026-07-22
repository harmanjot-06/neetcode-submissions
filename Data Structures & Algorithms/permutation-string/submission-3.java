class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> copymap = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            copymap.put(ch, copymap.getOrDefault(ch, 0)+1);
        }

        int l=0;
        int r=0;

        while(r<s2.length()){

            if(copymap.containsKey(s2.charAt(r))){
                map.put(s2.charAt(r), map.getOrDefault(s2.charAt(r), 0)-1);
                if(map.get(s2.charAt(r))==0){
                    map.remove(s2.charAt(r));
                }
            }

            if(r-l+1 < s1.length()){
                r++;
            }

            else if(r-l+1 == s1.length()){
                if(map.isEmpty()){
                    return true;
                }
                if(copymap.containsKey(s2.charAt(l))){
                    map.put(s2.charAt(l), map.getOrDefault(s2.charAt(l), 0)+1);
                    if(map.get(s2.charAt(l))==0){
                        map.remove(s2.charAt(l));
                    }
                }
                l++;
                r++;
            }
        }
        return false;

    }
}
