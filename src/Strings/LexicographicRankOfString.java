package Strings;
/*
*   abc -1 --------------- cba -6
*   acb-2
*   bac-3
*   bca-4
*   cab-5--------------------> cba-6 rank
*
* */

public class LexicographicRankOfString {
    public static void main(String... args){
        String s="string";


        System.out.println("final rank :"+findRank(s));
    }

    static int findRank(String s){
        int rank=0;
        int Belowones;
        int charsRight=s.length()-1;
        for(int i=0;i<s.length();i++){
            Belowones=0;
            //find below ranked ones comapred to current

            for(int j=i+1;j<s.length();j++){

                if(s.charAt(j)<s.charAt(i))
                    Belowones++;
            }

            //find factorial(belowones)* charsRight
            System.out.println("Belowones = " + Belowones);
            System.out.println("charsRight = " + charsRight);
            System.out.println(factorial(Belowones));
               rank+=factorial(charsRight)*Belowones;
            System.out.println("rank = " + rank);
            charsRight--;
        }
        return rank+1;
    }

    public static int factorial(int number) {
        if (number <= 1) return 1;
        else return number * factorial(number - 1);
    }
}
