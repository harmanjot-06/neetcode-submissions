class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length%groupSize!=0)return false;
        int groups = hand.length/groupSize;
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<hand.length; i++){
            min = Math.min(min, hand[i]);
            max = Math.max(max, hand[i]);
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        int startnum=min;
        System.out.println(startnum);
        int startgroupsleft = groups;
        while(startnum<=max){
            if(!map.containsKey(startnum)){
                startnum++;
                continue;
            }
            int startnumgroups = map.get(startnum);
            if(startnumgroups>startgroupsleft)return false;
            startgroupsleft-=startnumgroups;

            for(int inc=1; inc<groupSize; inc++){
                int num = startnum + inc;
                if(!map.containsKey(num))return false;
                if(map.get(num)<startnumgroups)return false;
                map.put(num, map.get(num)-startnumgroups);
                if(map.get(num)==0)map.remove(num);
            }
            startnum = startnum + 1;
        }
        return true;
    }
}
