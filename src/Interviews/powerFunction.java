package Interviews;

/**
 * Created by kaas0616 on 5/14/2018.
 */
public class powerFunction {

    public static void main(String[] args) {
long firsttime=System.currentTimeMillis();
        System.out.println("firsttime = " + firsttime);
        int a=12;int b=3;
        System.out.println(power(a,b));
        System.out.println(Optimisedpower(a,b));
        long secondtime=System.currentTimeMillis();
        System.out.println((secondtime-firsttime));
    }

    static int power(int a ,int b){
        if(b==0)
            return 1;

        if(b%2==0)
            return power(a,b/2)*power(a,b/2);
        else
            return a*power(a,b/2)*power(a,b/2);

    }
    static int Optimisedpower (int a ,int b){
        if(b==0)
            return 1;
        int temp=Optimisedpower(a,b/2);
        if(b%2==0)
            return temp*temp;
        else
            return a*temp*temp;
    }

}
