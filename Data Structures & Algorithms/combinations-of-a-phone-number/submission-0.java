class Solution {

    List<String> ans;

    public void helper(String digits, int i, String output){

        if(i==digits.length()){
            ans.add(output);
            return;
        }


        char ch = digits.charAt(i);
        String temp = output;

        if(ch=='2'){
            output+="a";
            helper(digits, i+1, output);
            output = temp;
            output+="b";
            helper(digits, i+1, output);
            output = temp;
            output+="c";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '3'){
            output+="d";
            helper(digits, i+1, output);
            output = temp;
            output+="e";
            helper(digits, i+1, output);
            output = temp;
            output+="f";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '4'){
            output+="g";
            helper(digits, i+1, output);
            output = temp;
            output+="h";
            helper(digits, i+1, output);
            output = temp;
            output+="i";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '5'){
            output+="j";
            helper(digits, i+1, output);
            output = temp;
            output+="k";
            helper(digits, i+1, output);
            output = temp;
            output+="l";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '6'){
            output+="m";
            helper(digits, i+1, output);
            output = temp;
            output+="n";
            helper(digits, i+1, output);
            output = temp;
            output+="o";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '7'){
            output+="p";
            helper(digits, i+1, output);
            output = temp;
            output+="q";
            helper(digits, i+1, output);
            output = temp;
            output+="r";
            helper(digits, i+1, output);
            output = temp;
            output+="s";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '8'){
            output+="t";
            helper(digits, i+1, output);
            output = temp;
            output+="u";
            helper(digits, i+1, output);
            output = temp;
            output+="v";
            helper(digits, i+1, output);
            return;
        }
        else if(ch == '9'){
            output+="w";
            helper(digits, i+1, output);
            output = temp;
            output+="x";
            helper(digits, i+1, output);
            output = temp;
            output+="y";
            helper(digits, i+1, output);
            output = temp;
            output+="z";
            helper(digits, i+1, output);
            return;
        }
    }


    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0)return ans;
        helper(digits, 0, "");
        return ans;

    }
}
