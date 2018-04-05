package Strings;


import java.util.Stack;

/*
* (a+b)-(c-d)
*
* o/p=a+b-c+d
* */
public class PlusMinusParenthesisRemovalEvaluator {
    public static void main(String... args){

        Stack<String> st= new Stack<>();
        st.push("0");
        String s="(a+b)-((c-d)+(e-f))";

        StringBuilder last = new StringBuilder();
        last.append("");
        StringBuilder sub= new StringBuilder();
        StringBuilder sub2= new StringBuilder();
        StringBuilder res= new StringBuilder();
        for(int i=0;i<=s.length();i++){
            if( i!=s.length() && s.charAt(i)!=')')
                st.push(String.valueOf(s.charAt(i)));
            else{
sub.delete(0,sub.length());
                System.out.println("st1 = " + st);
                while(!st.peek().equals("(") && !st.peek().equals("0")){

                    sub.append(st.peek());
                    st.pop();
                }
                if(st.peek().equals("("))
                st.pop();

                sub.reverse();

                if(st.peek()=="0") {
                    if(!last.toString().equals(""))
                        res.append(last);
                    else
                        res.append(sub);

                    last.delete(0, last.length());
                    System.out.println("last2 = " + last);
                }
                else if(st.peek().equals("-")){

                    sub2.delete(0,sub2.length());
                    //convert and append
                    if(!sub.toString().equals("")) {
                        if(sub.charAt(0)!= '-' ) {


                            sub2.append("-");
                            System.out.println("sub in - = " + sub);
                            for(int j=0;j<sub.length();j++){
                                if(sub.charAt(j)=='+')
                                    sub2.append("-");
                                else if(sub.charAt(j)=='-')
                                    sub2.append("+");
                                else
                                    sub2.append(sub.charAt(j));
                            }

                            last.append(sub2);
                        }
                    }
                    else{

                        if(last.charAt(0)!= '-' ) {


                            sub2.append("-");
                            System.out.println("sub in - = " + sub);
                            for(int j=0;j<last.length();j++){
                                if(last.charAt(j)=='+')
                                    sub2.append("-");
                                else if(last.charAt(j)=='-')
                                    sub2.append("+");
                                else
                                    sub2.append(last.charAt(j));
                            }
                            last.delete(0,last.length());
                            last.append(sub2);
                        }

                    }


                    System.out.println("sub2 = " + sub2);


                    st.pop();
                } else if (st.peek().equals("+")) {

                    //append
                    last.append("+");
last.append(sub);
                    st.pop();
                }
                else{

                    last.append(sub);
                    //st.pop();
                }

                System.out.println("sub = " + sub);
                System.out.println("res = " + res);
                System.out.println("last = " + last);
                System.out.println("st = " + st);

                }


            }

        System.out.println("res = " + res);
        }




    }

