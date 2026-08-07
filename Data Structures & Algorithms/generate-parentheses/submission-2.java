class Solution {

    List<String> ans;

    public void helper(int open, int close, String output){

        if(open > close){
            return;
        }
        if(open==0 && close==0){
            ans.add(output);
            return;
        }
        if(open<0 || close < 0){
            return;
        }

        String temp = output;
        temp+=")";
        output+="(";

        helper(open-1, close, output);
        helper(open, close -1, temp);

    }

    public List<String> generateParenthesis(int n) {
        // no of ) >= no of (

        ans = new ArrayList<>();
        helper(n, n, "");
        return ans;
    }
}
