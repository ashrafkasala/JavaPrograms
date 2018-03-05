package DynamicProgramming;

import java.util.Arrays;

public class fibonocci {

    public static void main(String[] args){
        fibonocci fib=new fibonocci();
        int n=2;
        int[] lookUp =new int[100];

        for(int i=0;i<99;i++)
            lookUp[i]=-1;

        System.out.println("fibonocci series "+fib.fibonnaci(n,lookUp));

        System.out.println("fibonocci series "+ Arrays.toString(lookUp));
    }

    int fibonnaci(int n,int[] lookUp){


        if(lookUp[n]==-1){

            if(n<=0)
                lookUp[n]=0;
           else if(n==1)
                lookUp[n]=1;
            else
            lookUp[n]=fibonnaci(n-1,lookUp)+fibonnaci(n-2,lookUp);

        }
        return lookUp[n];

    }
}
