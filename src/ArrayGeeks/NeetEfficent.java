package ArrayGeeks;

import java.util.Scanner;

public class NeetEfficent {

    public static void main(String... args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("enter number");
        final int RADIX = 10;
       // int i = 4;
        //char ch = Character.forDigit(i, RADIX);
        int n = scan.nextInt();
        String ns = String.valueOf(n);
        int index = -1;
        int rep = -1;
        for (int i = 0; i < ns.length() - 1; i++) {

            if (Integer.parseInt(String.valueOf(ns.charAt(i))) > Integer.parseInt(String.valueOf(ns.charAt(i + 1)))) {
                rep = Integer.parseInt(String.valueOf(ns.charAt(i)));
                index = i;
                break;
            }
        }

        for(int k=index;k>0;k--){
            if(Integer.parseInt(String.valueOf(ns.charAt(k))) == Integer.parseInt(String.valueOf(ns.charAt(k - 1)))){
                index=k-1;
            }
            else
                break;
        }

        if (index != -1) {
            StringBuilder ns2 = new StringBuilder(ns);
            ns2.setCharAt(index,Character.forDigit(rep-1, RADIX) );
            for (int i = index+1; i < ns.length(); i++) {
                    ns2.setCharAt(i,Character.forDigit(9,RADIX));
            }
            System.out.println("number is "+ns2);
        }
        else
        System.out.println("number is did nt change"+ns);

    }
}
