class Solution {

    public String encode(List<String> strs) {

        String ans = "<--->";
        for(String temp : strs){
            ans+=temp;
            ans+="<--->";
        }
        return ans;


    }

    public List<String> decode(String str) {
        String seperator = "<--->";
        List<String> ans = new ArrayList<>();
        System.out.println(str);

        int i = 5;
        int j = str.length()-5;
        int startIndex = 5;
        while(i<=j){
            int findIndex = str.indexOf("<--->", startIndex);
            String temp = "";
            if(i==findIndex){
                
            }
            else{
                while(i<findIndex){
                    temp+=str.charAt(i);
                    i++;
                }
            }
            ans.add(temp);
            i+=5;
            startIndex = i;
        }
        return ans;
    }
}
