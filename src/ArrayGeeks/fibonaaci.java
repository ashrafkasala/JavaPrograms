package ArrayGeeks;

import java.util.HashMap;

public class fibonaaci {
    static  HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib2(6));

    }

    static int fib(int n){

        if(n<=1)
        {
            return n;
        }

        if(map.containsKey(n))
            return map.get(n);
        System.out.println("n = " + n);
        map.put(n,fib(n-1)+fib(n-2));

        return map.get(n);
    }
    static int fib2(int n){
        if(n<=1)
            return n;
        System.out.println("n in fib2(with out optmised) = " + n);
        return fib2(n-1)+fib2(n-2);
    }
}
