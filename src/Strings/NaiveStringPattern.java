package Strings;

public class NaiveStringPattern {

    public static void main(String... args){

        String s="abdfcabndc";
String sub="abc";
int j;
        for(int i=0;i<s.length();i++){

            for(j=0;j<sub.length();j++) {
                if (sub.charAt(j)==s.charAt(i+j)) {

                }
                else
                    break;
            }

            if(j==sub.length()){
                System.out.println("substring found");
                break;
            }
            else
                System.out.println("not found");
        }
    }
}
