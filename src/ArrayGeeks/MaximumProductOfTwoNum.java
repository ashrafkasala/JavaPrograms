package ArrayGeeks;

/**
 * Created by kaas0616 on 2018-03-07.
 */
public class MaximumProductOfTwoNum {
    public static void main(String... args){

        int[] a={2,3,1,4,10,3};
        int maxsofar=a[0];
        int maxPro=Integer.MIN_VALUE;

        for(int i=1;i<a.length;i++){

            if(maxsofar*a[i] > maxPro)
                maxPro=maxsofar*a[i];
            if(a[i]>maxsofar)
                maxsofar=a[i];
        }

        System.out.println("max product  "+maxPro);
    }
}
