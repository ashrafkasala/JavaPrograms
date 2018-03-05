package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemsPhorePC2 {

    public static void main(String... args){
        PC pc = new PC();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<5;i++)
                    pc.produce(i);

                }
                catch(Exception e){}
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<5;i++)
                    pc.consume();}
                catch(Exception e){}
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){}


    }
}

class PC{
    int item;
    Semaphore semP = new Semaphore(1);
    Semaphore semC = new Semaphore(0);


    void produce(int item){
        try{
        semP.acquire();}
        catch(InterruptedException e){}

        this.item=item;

        System.out.println("producer produced "+item);
        semC.release();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void consume(){
        try{
            semC.acquire();
            Thread.sleep(1000);}
        catch(InterruptedException e){}

        System.out.println("Consumer consumed  "+item);

        semP.release();
    }
}
