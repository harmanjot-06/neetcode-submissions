class Solution {

    public int[] helper(String s, int l, int r){

        if(l<0){
            return new int[]{0,0};
        }

        while(l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            else{
                if(l+1==r){
                    return new int[]{l,l};
                }
                else{
                    return new int[]{l+1, r-1};
                }
            }
        }
        return new int[]{l+1, r-1};

    }

    public String longestPalindrome(String s) {
        
        int maxlen = -1;
        int l = 0;
        int r=0;

        for(int i=0; i<s.length(); i++){

            int[] odds = helper(s, i, i);
            int[] eves = helper(s, i-1, i);

            if((odds[1]-odds[0] + 1) > maxlen){
                maxlen = odds[1] - odds[0] + 1;
                l = odds[0];
                r = odds[1];
            }
            if((eves[1]-eves[0] + 1) > maxlen){
                maxlen = eves[1] - eves[0] + 1;
                l = eves[0];
                r = eves[1];
            }
        }

        return s.substring(l, r+1);

    }
}
