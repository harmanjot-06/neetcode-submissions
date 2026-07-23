class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

        for(String str : tokens){

            if(str.length()>1 || (str.charAt(0)!='+' && str.charAt(0)!='-' && str.charAt(0)!='*' 
            && str.charAt(0)!='/')){

                    Integer num = Integer.valueOf(str);
                    st.add(num);
            }
            else{
                System.out.print(st);
                Integer num2 = st.pop();
                
                Integer num1 = st.pop();

                if(str.charAt(0)=='+'){
                    st.add(num1 + num2);
                }
                else if(str.charAt(0)=='-'){
                    st.add(num1 - num2);
                }
                else if(str.charAt(0)=='*'){
                    st.add(num1*num2);
                }
                else{
                    st.add(num1/num2);
                }
            }

        }
        return st.pop();
    }
}
