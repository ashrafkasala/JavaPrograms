package Strings;

/**
 * Created by kaas0616 on 4/16/2018.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s="abZcbdbcbda";

        int oddL,oddR,evenL,evenR;
        boolean found=false;
        int max=Integer.MIN_VALUE,L=0,R=0;
        for(int i=0;i<s.length();i++){

            oddL=i-1;oddR=i+1;
            found=false;
            while(oddL>=0 && oddR<s.length()){

                if(s.charAt(oddL)==s.charAt(oddR)){
                    if(max<oddR-oddL+1){
                        max=oddR-oddL+1;
                        L=oddL;
                        R=oddR;
                    }

                    oddL--;
                    oddR++;
                }
                else
                    break;

            }

            evenL=i;
            evenR=i+1;

            while(evenL>=0 && evenR<s.length()){

                if(s.charAt(evenL)==s.charAt(evenR)){
                    if(max<evenR-evenL+1){
                        max=evenR-evenL+1;
                        L=evenL;
                        R=evenR;
                    }

                    evenL--;
                    evenR++;
                }
                else
                    break;

            }
        }

        System.out.println("max = " + max);
        System.out.println("L = " + L+"R= "+R+"  "+s.substring(L,R+1));
    }
}
