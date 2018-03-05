import java.util.Arrays;

/**
 * Created by kaas0616 on 2018-02-08.
 */
public class CuttingTheRod {
    public static void main(String... args ){
        int price[]={3,5,8,9,10,17,17,20};
        int[] lookUp=new int[price.length+1];
        lookUp[0]=0;
        for(int i=1;i<=price.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){

                 max=Math.max(max,price[j]+lookUp[i-j-1]);
            }
            lookUp[i]=max;
        }

        System.out.println("lookUP "+ Arrays.toString(lookUp));
    }

}
