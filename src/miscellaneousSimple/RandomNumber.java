package miscellaneousSimple;

import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {
        Random rnd = new Random();
         int n=10;

         //random number generation from 1 to n with random probability
         for(int i=0;i<n;i++)
        System.out.println(rnd.nextInt(n)+1);



    }
}
