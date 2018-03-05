package ArrayGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrimeFactorization {

    public static void main(String... args){
        System.out.println("enter number");
        ArrayList<Integer> res=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();

        while(n%2==0 && n>0){
            n=n/2;
            res.add(2);
        }

        for(int i=3;i<=n;i=i+2){

            while(n%i==0 && n>0){
                n=n/i;
                res.add(i);
            }
            if(n==0)
                break;
        }
        System.out.println(res);
System.out.println(Collections.frequency(res,2));

    }
}
