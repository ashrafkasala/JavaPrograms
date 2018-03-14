package BitWiseAlgos;


/**
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

 Write a function to find the nth Magic number.

 Example:

 Input: n = 2
 Output: 25

 Input: n = 5
 Output: 130
 */

/**
 * Created by kaas0616 on 2018-03-13.
 */
public class NthMagicNum {
    public static void main(String... r){

        int n=6;
        int res=0,pow=1;
        while(n!=0){
            pow*=5;

            if((n & 1)==1){

                res+=pow;
            }

            n>>=1;

        }

        System.out.println(res);




    }
}
