package ArrayGeeks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by kaas0616 on 5/8/2018.
 */
public class slidingwindowMaximum {
    public static void main(String[] args) {
        int a[] = {10,1,3,1,-2,4,8,2,13};

        Deque<Integer> Q=new LinkedList<>();

        //main tain deque of useful elements ie elements left to that are lesser

        int k=3,i=0;
        for( i=0;i<k;i++){

            while(!Q.isEmpty() && a[Q.peekLast()]<=a[i])
                Q.removeLast();
            Q.addLast(i);
        }

        for(;i<a.length;i++){

            System.out.print(a[Q.peek()]+"  ");

            while(!Q.isEmpty() && Q.peek()<=i-k){
                Q.removeFirst();
            }

            while(!Q.isEmpty() && a[Q.peekLast()]<=a[i])
                Q.removeLast();
            Q.addLast(i);
        }
        System.out.print(a[Q.peek()]+"  ");

    }
}
