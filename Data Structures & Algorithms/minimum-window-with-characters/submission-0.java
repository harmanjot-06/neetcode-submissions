class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length())return "";

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> copymap = new HashMap<>();

        for(Character ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            copymap.put(ch, copymap.getOrDefault(ch, 0)+1);
        }

        int l=0;
        int r=0;
        int min = s.length();
        int ansl = -1;
        int ansr = -1;
        int mapcount = map.size();

        while(r<s.length()){
            if(copymap.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
                if(map.get(s.charAt(r))==0)mapcount--;
                System.out.println("map : " + map + " l : " + l + " r " +r + " count : " + mapcount);
            }
            
            if(mapcount==0){
                min = Math.min(min, r-l+1);
                if(min==r-l+1){
                    ansl=l;
                    ansr=r;
                }

                System.out.println(ansl + " " + ansr);
                
                while(mapcount==0){
                    min = Math.min(min, r-l+1);
                    if(min==r-l+1){
                        ansl=l;
                        ansr=r;
                    }
                    if(copymap.containsKey(s.charAt(l))){
                        map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)+1);
                        if(map.get(s.charAt(l))>0){
                            mapcount++;
                        }
                    }
                    l++;
                }
                r++;
            }
            else{
                r++;
            }
        }

        String ans = "";

        if(ansl!=-1){
            for(int i=ansl; i<=ansr; i++){
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}
