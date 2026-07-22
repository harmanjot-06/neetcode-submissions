class Solution {

    public String encode(List<String> strs) {

        String encoded = "";
        for(String temp : strs){
            
            encoded+=String.valueOf(temp.length());
            encoded+="#";
            encoded+=temp;
        }
        System.out.println(encoded);
        return encoded;


    }

    public List<String> decode(String str) {
        
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            
            int len = 0;

            int index = i;
            while(str.charAt(index)!='#'){
                len = len*10 + (str.charAt(index) - '0');
                index++;
            }

            int start = index+1;
            int end = start + len - 1;
            String temp = "";

            while(start<=end){
                System.out.println(len);
                temp+=str.charAt(start);
                start++;
            }
            ans.add(temp);
            i = end + 1;
        }

        return ans;

    }
}
