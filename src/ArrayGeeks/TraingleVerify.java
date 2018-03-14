package ArrayGeeks;

/**
 * Created by kaas0616 on 2018-03-14.
 */
public class TraingleVerify {
    public static void main(String... args){

        int a[] ={1,4,2,43,1};
        int b[] ={2,4,1,12,1};
        int c[] ={5,2,3,42,1};


        for(int i=0;i<a.length;i++){

            if(validate(a[i],b[i],c[i])){

                System.out.println("form  trainale "+a[i]+"  "+b[i]+" "+c[i]);
            }
            else
                System.out.println("does not form  trainale "+a[i]+"  "+b[i]+" "+c[i]);
        }


    }

    static boolean validate(int a, int b,int c){

        if((a+b)<c || (b+c)<a || (a+c)<b)
            return false;


        return true;

    }
}
