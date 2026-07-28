class Solution {
    public int numDecodings(String s) {
        int[] dp =  new int[s.length() + 1];
        dp[0] = 1;
        if(s.charAt(0)=='0'){
            dp[1] = 0;
        }
        else{
            dp[1] = 1;
        }

        for(int i=2; i<=s.length(); i++){
            int temp = 0;
            if(s.charAt(i-1)!='0'){
                temp+= dp[i-1];
            }
            if(s.charAt(i-2)=='1'){
                temp+=dp[i-2];
            }
            else if(s.charAt(i-2)=='2' && s.charAt(i-1)<='6'){
                temp+=dp[i-2];
            }
            dp[i] = temp;
        }

        return dp[s.length()];


    }
}
