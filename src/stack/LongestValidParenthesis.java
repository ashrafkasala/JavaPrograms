package stack;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String... args){
        String s= "())(()()))";
        int n=s.length();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='(')
                st.push(i);
            else{

                if(st.isEmpty())
                    st.push(i);
                else{

                    if(s.charAt(st.peek())=='(')
                        st.pop();
                    else
                        st.push(i);
                }

            }


        }



        if(st.isEmpty())
            System.out.println(s.length());
        else{

            int a=n;
            int b=0;
            int max=Integer.MIN_VALUE;
            while (!st.isEmpty()){
                b=st.peek();
                st.pop();

                max=Math.max(max,a-b-1);
                a=b;
            }

            System.out.println("max = " + max);

        }


    }
}
