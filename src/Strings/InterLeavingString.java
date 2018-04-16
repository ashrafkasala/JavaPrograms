package Strings;

/**
 * Created by kaas0616 on 4/16/2018.
 */
public class InterLeavingString {
    public static void main(String[] args) {
        String s1="ash";
        String s2="bros";
        String s3="asbrohs";

        boolean Ins1,Ins2;
        int l1=s1.length()-1,l2=s2.length()-1,l3=s3.length()-1;
        int i=0,j=0,k=0;
        while (k<=l3){
            Ins1=false;
            while(i<=l1 && s3.charAt(k)==s1.charAt(i))
            {
                i++;
                k++;
                Ins1=true;
            }
            Ins2=false;

            while(j<=l2 && s3.charAt(k)==s2.charAt(j)){
                j++;
                k++;
                Ins2=true;
            }

            if(!Ins1 && !Ins2)
                break;

        }

        if(k==l3+1)
            System.out.println("interleaving");
        else
            System.out.println("not interleaving");
    }
}
