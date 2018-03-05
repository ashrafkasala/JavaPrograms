import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class CheckPrime {

    public static void main(String args[]){

        CheckPrime c = new CheckPrime();
        Scanner scan = new Scanner(System.in);
System.out.println("enter number");
        long n = scan.nextLong();

        c.checkPrime(n);
       c.checkPrimeEfficient(n);
    }

    public static void checkPrime(long n){

        for (long i=2;i<=n-1;i++){
            if(n%i ==0){
                System.out.println("Not a Prime Number"+n);
                break;
            }
        }
    }

    public static void checkPrimeEfficient(long n){

        for (long i=2;i<=sqrt(n);i++){
            if(n%i ==0){
                System.out.println("Not a Prime Number"+n);
                break;
            }
        }
    }
}
