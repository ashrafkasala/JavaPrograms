package BitWiseAlgos;

/**
 * Created by kaas0616 on 2018-03-13.
 */
public class intToHex {

    public static void main(String... args){

        String str2="";
int num=123;
int rem;
        // Digits in hexadecimal number system
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(num>0)
        {
            rem=num%16;
            str2=hex[rem]+str2;
            num=num/16;
        }
        System.out.println("Method 2: Decimal to hexadecimal: "+str2);
    }

    }

