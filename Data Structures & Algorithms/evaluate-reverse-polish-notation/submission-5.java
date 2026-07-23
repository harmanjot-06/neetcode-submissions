class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

    



        for(String str : tokens){


            Integer num14 = 0;
            boolean sym = false;
            try{
                num14 = Integer.valueOf(str);
            }
            catch (Exception E){
                sym = true;
            }

            if(sym==false){

                    // Integer num = Integer.valueOf(str);
                    st.add(num14);
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
