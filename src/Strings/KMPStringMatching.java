package Strings;

import java.util.Arrays;

public class KMPStringMatching {
    // JAVA program for implementation of KMP pattern
// searching algorithm

        void KMPSearch(String pat, String txt)
        {
            int M = pat.length();
            int N = txt.length();

            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int lps2[]=new int[M];
            int j = 0;  // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat,M,lps);
            computeLPSArray2(pat,M,lps2);
System.out.println(Arrays.toString(lps));
            int i = 0;  // index for txt[]
            while (i < N)
            {
                if (pat.charAt(j) == txt.charAt(i))
                {
                    j++;
                    i++;
                }
                if (j == M)
                {
                    System.out.println("Found pattern "+
                            "at index " + (i-j));
                    j = lps[j-1];
                }

                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i))
                {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j-1];
                    else
                        i = i+1;
                }
            }

            //solution 2
            j=0;
            for( i=0;i<N;i++){

                if(txt.charAt(i)==pat.charAt(j)){

                    j++;
                    if(j==M) {
                        System.out.println("found at "+(i-j+1));
                        break;
                    }

                }
               else{

                    while(j>0){

                        j=lps2[j-1];
                        if(txt.charAt(i)==pat.charAt(j))
                        {
                            j++;
                            break;
                        }
                    }
                }


            }


        }

        void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int j = 0;
            int i = 1;
            lps[0] = 0;  // lps[0] is always 0

            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M)
            {

                if (pat.charAt(i) == pat.charAt(j))
                {
                    j++;
                    lps[i] = j;
                    i++;
                }
                else  // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (j != 0)
                    {
                        j = lps[j-1];

                        // Also, note that we do not increment
                        // i here
                    }
                    else  // if (len == 0)
                    {
                        lps[i] = j;
                        i++;
                    }
                }
            }
            System.out.println(Arrays.toString(lps));
        }
    void computeLPSArray2(String pat, int M, int lps2[])
    {

        int i=1,j=0;
        lps2[0]=0;

        for( i=1;i<M;i++){

            if(pat.charAt(i)==pat.charAt(j)){
                j++;
                lps2[i]=j;
            }
            else{

                while(j>0){

                    j=lps2[j-1];
                    if(pat.charAt(i)==pat.charAt(j))
                    {
                        lps2[i]=j+1;
                        break;
                    }
                }
                if(j==0){
                    lps2[i]=0;
                    j=0;
                }
            }
        }

        System.out.println(Arrays.toString(lps2));
    }

        // Driver program to test above function
        public static void main(String args[])
        {
            String txt = "ABZAZDABACDABABCABAB";
            String pat = "ABABCABAB";
            String pat2="ZDABA";
            new KMPStringMatching   ().KMPSearch(pat2,txt);
        }
    }

