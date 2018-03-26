package miscillaneousHard;

import java.util.Stack;


/**
 * algo :
 *
 *          1. if '('  push index
 *          2.if ')'
 *               1 pop
 *               2 if stack empty push index else find length by taking diff of (index-s.peek())
 *               3 comapre with reulst and update if higher
 */
public class LongestValidParenthesis {
    public static void main(String... args){

       String s="()(()(((";
       int count=0;
        int lenght=Integer.MIN_VALUE;
        Stack<Integer> openStack = new Stack<>();
        openStack.push(-1);
        int res=0;
        //Stack<String> closeStack = new Stack<>();
       for(int i=0;i<s.length();i++){

           if(s.charAt(i)=='(')
               openStack.push(i);

           if(s.charAt(i)==')'){

               openStack.pop();

               if(openStack.isEmpty())
                   openStack.push(i);
               else
                   res=Math.max(res,i-openStack.peek());
//               if(openStack.isEmpty()){
//                   count=0;
//                   continue;
//               }
//
//            //   else if(closeStack.isEmpty()){
//else{
//                   count=count+2;
//                   openStack.pop();
//               }
           }

           if(count>lenght)
               lenght=count;

       }

       System.out.println(res);

    }
}
