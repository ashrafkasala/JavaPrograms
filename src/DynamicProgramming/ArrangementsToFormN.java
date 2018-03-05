package DynamicProgramming;

import java.util.Arrays;

public class ArrangementsToFormN {
    static int[] lookUp=new int[100];


    public static void main(String[] args){
        ArrangementsToFormN arrange = new ArrangementsToFormN();
        int[] arr= {1,3,5};
        int N=20;
        for(int i=0;i<100;i++) {
            lookUp[i] = -1;
        }
        arrange.findArrangements(N);
        System.out.println("Arrangements  "+ Arrays.toString(lookUp));
    }

    int findArrangements(int N){
        if(N<0)
            return 0;
        if(N==0)
            return 1;
        if(lookUp[N]!=-1)
            return lookUp[N];
        return lookUp[N]=findArrangements(N-1)+findArrangements(N-3)+findArrangements(N-5);
    }
}
