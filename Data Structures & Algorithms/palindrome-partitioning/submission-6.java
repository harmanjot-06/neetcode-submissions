class Solution {

    List<List<String>> ans;

    public boolean pal(String str){
        int i = 0;
        int j = str.length()-1;

        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean palcheck(List<String> l){
        for(String s : l){
            if(!pal(s))return false;
        }
        return true;
    }

    public void helper(String s, int i, List<String> output){
        if(i==s.length()){

            if(palcheck(output)){
                ans.add(new ArrayList<>(output));
            }
            return;
        }
        if(i==0){
            String temp = "" + s.charAt(i);
            output.add(temp);
            helper(s, i+1, output);
            // output.remove(output.size()-1);
            return;
        }

        String temp = "" + s.charAt(i);
        output.add(temp);
        helper(s, i+1, output);
        output.remove(output.size()-1);


        String prev = output.get(output.size()-1);
        String newcheck = prev + s.charAt(i);
        if(output.size()==0){
            output.add(newcheck);
        }else{
        output.set(output.size()-1, newcheck);
        }
        // System.out.println("after newcheck " + output);
        helper(s, i+1, output);
        // if(output.size()!=0){
        // output.remove(output.size()-1);
        // }
        // System.out.println("final remove " + output);
        return;
    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return ans;
    }
}
