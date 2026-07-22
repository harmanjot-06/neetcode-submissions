class Solution {
    public boolean isPalindrome(String s) {
        int i=0; 
        int j=s.length()-1;

        while(i<j){
            if(!((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))){
                i++;
                continue;
            }
            if(!((s.charAt(j)>='A' && s.charAt(j)<='Z') || (s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)>='0' && s.charAt(j)<='9'))){
                j--;
                continue;
            }

            char left = s.charAt(i);
            char right = s.charAt(j);

            if(left>='A' && left<='Z'){
                left+=32;
            }

            if(right>='A' && right<='Z'){
                right+=32;
            }

            if(left!=right){
                System.out.println("i: " + s.charAt(i) + " j: " + s.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
