package ArrayGeeks;

import java.util.Scanner;

public class neetnumber {

    public static void main(String... args){
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();

        for(int i=n;i>0;i--){

           if( checkNeet(i))
               break;
        }
    }

   static boolean checkNeet(int n){
        int current;
        int value=n;
        int prev=Integer.MAX_VALUE;
        while(n>0){
            current=n%10;
            if(current<=prev)
                prev=current;
            else
                return false;
            n=n/10;
        }

        System.out.println(value);
        return  true;
    }

}
