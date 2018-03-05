/**
 * Created by kaas0616 on 2018-02-27.
 */
public class OddDivisorSum {
    public static void main(String... args){


        int n=11;
        int sum=0;
        for(int i=1;i<=n;i=i+2){
            if (n%i==0){
                sum=sum+i;
            }

        }

        System.out.print("sum ood "+sum);

    }
}
