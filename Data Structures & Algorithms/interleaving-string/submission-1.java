class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        if(s3.length()==0)return true;

        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];

        dp[0][0] = true;

        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i+j==0)continue;

                int s3len = i + j;
                boolean ans = false;
                if((i-1>=0) && s3.charAt(s3len-1) == s1.charAt(i-1)){
                    ans = ans || dp[i-1][j];
                }
                if((j-1>=0) && s3.charAt(s3len-1) == s2.charAt(j-1)){
                    ans = ans || dp[i][j-1];
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
