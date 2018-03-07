package MultiThreading;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;


public class SemaphoreProdCons {

    public static void main(String... args){
        final ProdCons22 pc =new ProdCons22();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }
                catch (InterruptedException e){}
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                }
                catch (InterruptedException e){}
            }

        });
        t1.start();
        t2.start();

        try{t1.join();}
        catch (InterruptedException e){}
        try{t2.join();}
        catch (InterruptedException e){}

    }
}


class ProdCons22{
Semaphore sem= new Semaphore(1);
LinkedList<Integer> list = new LinkedList<>();
    int capacity=2;
    int value=0;
    void  produce() throws InterruptedException{
        sem.acquire();
        while (true) {

                while (list.size() == capacity) {
                    System.out.println("FULL : goto consumer lock released capacity is full");
                    sem.release();

                }
                list.add(value);
                System.out.println("Producer produced " + value);
                value++;
               // notify();
                Thread.sleep(1000);

        }
    }

    void consume() throws InterruptedException {
        sem.acquire();
        while (true) {

                while (list.size() == 0) {
                    System.out.println("Empty : Goto Producer lock released capacity is empty");
                    sem.release();

                }
                System.out.println("Consumer consumed " + list.removeFirst());
             //   notify();
                value--;
                Thread.sleep(1000);
        }
    }
}
