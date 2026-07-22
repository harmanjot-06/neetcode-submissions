class Solution {

    public String helper(String[] strs, int i, int j){
        if(i==0 && j==0){
            return strs[i];
        }

        String latestLCP = helper(strs, i, j-1);
        String curr = strs[j];
        String newLCP = "";
        for(int k=0; k<Math.min(latestLCP.length(), curr.length()); k++){
            if(latestLCP.charAt(k)==curr.charAt(k)){
                newLCP+=latestLCP.charAt(k);
            }
            else{
                break;
            }
        }
        return newLCP;
    }
    public String longestCommonPrefix(String[] strs) {
        return helper(strs, 0, strs.length - 1);
    }
}