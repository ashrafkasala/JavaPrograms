package ArrayGeeks;

import java.util.Arrays;

public class MinimumSumElementsfromThreeArrays {

    public static void main(String... args){

        int[] a={6,7,10};
        int[] b={1,3,4,7,9};
        int[] c={1,5,9};

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int res[]= new int[3];
        int min=Integer.MAX_VALUE;
        int current=0;
        for(int i=0;i<3;i++){
            if(i==0)
             current=getMin(a,b,c);
            if(i==1)
                current=getMin(b,c,a);
            if(i==2)
                current=getMin(c,a,b);

            System.out.println("current = " + current);
            if(min>current)
                min=current;
        }

        System.out.println("min = " + min);
    }

    static int getMin(int[] a1,int[] b1,int[] c1){
        int aPt=0;
        int bPt=0;
        int cPt=0;
        int min;
        boolean flag=false;
        boolean flag2;
        int finalMin=Integer.MAX_VALUE;
        for(int i=0;i<a1.length;i++){
            min=0;
            flag2=false;
            flag=false;
            for(int j=bPt;j<b1.length;j++){
                if(b1[j]>=a1[i]) {
                    bPt=j;
                    min=Math.abs(a1[i]-b1[j]);
                    flag=true;
                    break;
                }
            }
            if(flag) {
                for (int k = cPt; k < c1.length; k++) {

                    if (c1[k] >= b1[bPt]) {
                        cPt = k;
                        min += Math.abs(a1[i] - c1[k]);
                        min += Math.abs(b1[bPt] - c1[k]);
                        flag2=true;
                        break;
                    }
                }
            }

            if(min<finalMin && flag2)
            {
                finalMin=min;

            }

        }
        return finalMin;
    }


}
