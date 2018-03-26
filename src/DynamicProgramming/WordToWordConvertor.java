package DynamicProgramming;

import java.util.Arrays;

/**
 * Need to convert one string to other using min operations of insert,remove,replace
 *
 * DP bottom up approach
 */

public class WordToWordConvertor {

    public static void main(String... args){

        String s1="catt";
        String s2="ant";


        int res[][]= new int[s2.length()+1][s1.length()+1];


        for(int i=0;i<=s1.length();i++)
            res[0][i]=i;
        for(int i=0;i<=s2.length();i++)
            res[i][0]=i;

int min=Integer.MAX_VALUE;
        for(int i=1;i<=s2.length();i++){

            for(int j=1;j<=s1.length();j++){

                if(s2.charAt(i-1)==s1.charAt(j-1))
                    res[i][j]=Math.min(res[i-1][j-1],Math.min(res[i][j-1],res[i-1][j]));
                else
                    res[i][j]=Math.min(res[i-1][j-1],Math.min(res[i][j-1],res[i-1][j]))+1;

            }
        }
for(int i=0;i<=s2.length();i++)
        System.out.println("res = " + Arrays.toString(res[i]));
        System.out.println("res = " + res[s2.length()][s1.length()]);

    }
}
