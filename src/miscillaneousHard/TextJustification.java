package miscillaneousHard;

import java.util.Arrays;
import java.util.Scanner;

public class TextJustification {

    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of words");
       int n=scan.nextInt();
        System.out.println("Enter Line Length");
       int L =scan.nextInt();
       String[] words= new String[n];
String[] res= new String[10];
        System.out.println("Enter  words");
        for(int i=0;i<n;i++){
            words[i]=scan.next();
        }

        System.out.println(Arrays.toString(words));

        int countSpace=0;
        int init=0;
        int len;
        int start=0;
        int i=0;
        for( i=0;i<words.length;i++){
           init=init+words[i].length();
            if((init+countSpace)<=L) {
              //  init=init+words[i].length();
                countSpace++;
                continue;
            }
            //make adjusment upto start to i-1

            int totalWordLength=init-words[i].length();
            int spaces =L-totalWordLength;
            int NumberOfWords=i-start;
            int firstwordSpace;
            int remSpace;
            if(spaces%2==0){
if(NumberOfWords!=1) {
    firstwordSpace = spaces / (NumberOfWords - 1);
    remSpace = firstwordSpace;
}
else{
    firstwordSpace = spaces ;
    remSpace=0;
}
            }
            else
            {
                if(NumberOfWords!=1) {
                    firstwordSpace = spaces / (NumberOfWords - 1)  +1;
                    remSpace = spaces/(NumberOfWords-1);
                }
                else{
                    firstwordSpace = spaces;
                    remSpace =0;
                }

            }

            StringBuilder s=  new StringBuilder();
            System.out.println(s);
            s.append(words[start]);
            for(int sp=0;sp<firstwordSpace;sp++)
                s.append(" ");
            for(int k=start+1;k<i-1;k++){

                s.append(words[start]);
                for(int sp=0;sp<remSpace;sp++)
                s.append(" ");
            }
            if(NumberOfWords!=1)
            s.append(words[i-1]);


            System.out.println(s);

            countSpace=0;
            init=0;
            start=i;
            i--;

        }


        int totalWordLength=init;
        int spaces =L-totalWordLength;
        int NumberOfWords=i-start;
        int firstwordSpace;
        int remSpace;
        if(spaces%2==0){
            if(NumberOfWords!=1) {
                firstwordSpace = spaces / (NumberOfWords - 1);
                remSpace = firstwordSpace;
            }
            else{
                firstwordSpace = spaces ;
                remSpace=0;
            }
        }
        else
        {
            if(NumberOfWords!=1) {
                firstwordSpace = spaces / (NumberOfWords - 1)  +1;
                remSpace = spaces/(NumberOfWords-1);
            }
            else{
                firstwordSpace = spaces;
                remSpace =0;
            }
            firstwordSpace=spaces/NumberOfWords+1;
            remSpace=spaces/NumberOfWords;
        }

        StringBuilder s=  new StringBuilder();
        System.out.println(s);
        s.append(words[start]);
        for(int sp=0;sp<firstwordSpace;sp++)
            s.append(" ");
        for(int k=start+1;k<i-1;k++){

            s.append(words[start]);
            for(int sp=0;sp<remSpace;sp++)
                s.append(" ");
        }

        if(NumberOfWords!=1)
        s.append(words[i-1]);


        System.out.println(s);

    }
}
