package DynamicProgramming;

import java.util.Arrays;

public class fibTabulation {
    static int n=6;
   static int[] f=new int[n+1];
    public static void main(String[] args){
        fibTabulation fib=new fibTabulation();

        System.out.println("fibonocci series "+fib.fibonnaci(n));

        System.out.println("fibonocci series "+ Arrays.toString(f));
    }

    int fibonnaci(int n){
        f[0]=0;
        f[1]=1;
        //first build table and get results

        for(int i=2;i<=n;i++)
            f[i]=f[i-1]+f[i-2];
return f[n];
    }
}

