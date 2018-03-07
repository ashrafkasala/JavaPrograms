package Strings;

public class repeatedPatternInString {

    static int lps[];

    public static void main(String... args){

        String s="abcdabc";

        computeLPSArray(s);
        int N= s.length();
        int len=lps[N-1];

        if(len>0 && N%(N-len)==0)
            System.out.println("Pattern repeated");
        else
            System.out.println("Pattern Not  repeated");
    }

    static void computeLPSArray(String s){

lps = new int[s.length()];

int j=0;
int i=1;

   while(i<s.length()){
       if(s.charAt(i)==s.charAt(j)){
           lps[i]=++j;
           i++;
       }

       else{
           if(j!=0)
               j=lps[j-1];
           else{
               lps[i]=0;
               i++;

       }}

   }


    }
}
