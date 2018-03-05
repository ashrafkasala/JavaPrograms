package MultiThreading;

import java.util.concurrent.Semaphore;

public class OddEvenWIthSemaphore {

    public static void main(String... args){
        OddEven oe = new OddEven();
        int n=10;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<n;i=i+2){
                    oe.odd(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=2;i<n;i=i+2){
                    oe.even(i);
                }
            }
        });

        t1.start();
        t2.start();

    }
}

class OddEven{
    Semaphore oddS = new Semaphore(1);
    Semaphore evenS = new Semaphore(0);

    void odd(int num){
        try{
        oddS.acquire();}
        catch (InterruptedException e){}

        System.out.println(num);

        evenS.release();

    }

    void even(int num){
        try{
            evenS.acquire();}
        catch (InterruptedException e){}

        System.out.println(num);

        oddS.release();
    }
}