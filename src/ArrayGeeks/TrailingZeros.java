package ArrayGeeks;

import java.util.Scanner;

public class TrailingZeros {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

       n= GetNumber(n);
       System.out.println(n);
       int count=0;
       while(n>0){
           if(n%10==0){
               count++;
               n=n/10;
           }
           else
               break;
       }
       System.out.println(count);
    }

    static int GetNumber(int n){
        if(n==0)
            return 2;
        if(n==1)
            return 5;
        return GetNumber(n-1)*GetNumber(n-2);
    }

}
